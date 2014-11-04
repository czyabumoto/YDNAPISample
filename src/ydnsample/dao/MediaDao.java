package ydnsample.dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.ws.Holder;

import jp.yahooapis.im.V4.MediaService.*;
import jp.yahooapis.im.V4.MediaService.Error;
import jp.yahooapis.im.V4.error.impl.MediaServiceErrorEntityFactory;
import jp.yahooapis.im.V4.util.SoapUtils;
import ydnsample.util.Display;

public class MediaDao {

	private static MediaServiceInterface mediaService;

	static {
		try {
			mediaService = SoapUtils.createServiceInterface(MediaServiceInterface.class, MediaServiceService.class);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * アカウント内のキャンペーンを取得する
	 * 
	 * @param adGroupId
	 * @return
	 * @throws ApiException
	 */
	public static MediaRecord find(long accountId, long mediaId) throws ApiException {
		MediaSelector mediaSelector = new MediaSelector();
		Paging mediPaging = new Paging();
		mediPaging.setStartIndex(1);
		mediPaging.setNumberResults(20);

		mediaSelector.setAccountId(accountId);
		mediaSelector.getMediaIds().add(mediaId);
		mediaSelector.setPaging(mediPaging);

		// call API
		Holder<MediaPage> mediaPageHolder = new Holder<MediaPage>();
		Holder<List<Error>> mediaErrorHolder = new Holder<List<Error>>();
		mediaService.get(mediaSelector, mediaPageHolder, mediaErrorHolder);

		// if error
		if (mediaErrorHolder.value != null && mediaErrorHolder.value.size() > 0) {
			SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(mediaErrorHolder.value), true);
		}

		// response
		List<MediaRecord> medias = new ArrayList<>();
		if (mediaPageHolder.value != null) {
			MediaPage mediaPage = mediaPageHolder.value;
			if (mediaPage.getValues() != null && mediaPage.getValues().size() > 0) {
				for (int i = 0; i < mediaPage.getValues().size(); i++) {
					List<MediaValues> values = mediaPage.getValues();
					if (values.get(i).isOperationSucceeded()) {
						// display response
						medias.add(values.get(i).getMediaRecord());
					} else {
						// if error
						SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(values.get(i).getError()), true);
					}
				}
			}
		}

		if (medias.size() > 0)
			return medias.get(0);
		else
			return null;
	}

	public static void addMedia(long accountId, MediaRecord media) throws ApiException {
		MediaOperation mediaOperation = new MediaOperation();
		mediaOperation.setOperator(Operator.ADD);
		mediaOperation.setAccountId(accountId);

		media.setAccountId(accountId);

		mediaOperation.getOperand().add(media);

		// call API
		Holder<MediaReturnValue> mediaReturnValueHolder = new Holder<MediaReturnValue>();
		Holder<List<Error>> mediaSetErrorHolder = new Holder<List<Error>>();
		mediaService.mutate(mediaOperation, mediaReturnValueHolder, mediaSetErrorHolder);

		// if error
		if (mediaSetErrorHolder.value != null && mediaSetErrorHolder.value.size() > 0) {
			SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(mediaSetErrorHolder.value), true);
		}

		// response
		if (mediaReturnValueHolder.value != null) {
			MediaReturnValue returnValue = mediaReturnValueHolder.value;
			if (returnValue.getValues() != null) {
				List<MediaValues> mediaValuesList = returnValue.getValues();
				for (MediaValues mediaValues : mediaValuesList) {
					if (mediaValues.isOperationSucceeded()) {
						// display response
						System.out.println(String.format("Set media %d", media.getMediaId()));
						Display.print(mediaValues.getMediaRecord());
					} else {
						// if error
						SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(mediaValues.getError()), true);
					}
				}
			}
		}
	}

	public static void removeMedia(long accountId, long mediaId) throws ApiException {
		MediaRecord media = find(accountId, mediaId);

		MediaOperation mediaOperation = new MediaOperation();
		mediaOperation.setOperator(Operator.REMOVE);
		mediaOperation.setAccountId(accountId);

		media.setAccountId(accountId);

		mediaOperation.getOperand().add(media);

		// call API
		Holder<MediaReturnValue> mediaReturnValueHolder = new Holder<MediaReturnValue>();
		Holder<List<Error>> mediaSetErrorHolder = new Holder<List<Error>>();
		mediaService.mutate(mediaOperation, mediaReturnValueHolder, mediaSetErrorHolder);

		// if error
		if (mediaSetErrorHolder.value != null && mediaSetErrorHolder.value.size() > 0) {
			SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(mediaSetErrorHolder.value), true);
		}

		// response
		if (mediaReturnValueHolder.value != null) {
			MediaReturnValue returnValue = mediaReturnValueHolder.value;
			if (returnValue.getValues() != null) {
				List<MediaValues> mediaValuesList = returnValue.getValues();
				for (MediaValues mediaValues : mediaValuesList) {
					if (mediaValues.isOperationSucceeded()) {
						// display response
						System.out.println(String.format("Removed media %d", media.getMediaId()));
						Display.print(mediaValues.getMediaRecord());
					} else {
						// if error
						System.err.println(String.format("Removing Error Media MediaId=%d", media.getMediaId()));
						SoapUtils.displayErrors(new MediaServiceErrorEntityFactory(mediaValues.getError()), true);
					}
				}
			}
		}
	}
}
