package ydnsample.builder;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;

import jp.yahooapis.im.V4.MediaService.*;

public class MediaBuilder {

	private MediaRecord media = new MediaRecord();

	public MediaBuilder withAccountId(long accountId) {
		media.setAccountId(accountId);
		return this;
	}

	public MediaBuilder withId(long adId) {
		media.setMediaId(adId);
		return this;
	}

	public MediaBuilder withName(String mediaName) {
		media.setMediaName(mediaName);
		return this;
	}

	public MediaBuilder withTitle(String title) {
		media.setMediaTitle(title);
		return this;
	}

	public MediaBuilder withUserStatus(UserStatus status) {
		media.setUserStatus(status);
		return this;
	}

	public MediaBuilder withMedia(File imageFile, String downloadUrl) {
		try {
			ImageMedia im = new ImageMedia();
			im.setFileSize(imageFile.length());
			BufferedImage image = ImageIO.read(imageFile);
			int width = image.getHeight(), height = image.getHeight();
			im.setHeight(new Long(width));
			im.setWidth(new Long(height));
			im.setMediaAdFormat(getFormat(width, height));
			im.setMediaFileType(getFileType(imageFile.getName()));
			im.setData(readFile(imageFile));
			im.setDownloadUrl(downloadUrl);
			media.setMedia(im);
			return this;
		} catch (Exception ex) {
			ex.printStackTrace();
			System.exit(1);
			return null;
		}
	}
	
	private byte[] readFile(File file) throws IOException {
		BufferedInputStream fis = null;
		List<byte[]> buffer = new ArrayList<>();
		try {
			fis = new BufferedInputStream(new FileInputStream(file));
			int avail;
			int length = 0;
			while((avail = fis.available()) > 0) {
				byte[] bytes = new byte[avail];
				fis.read(bytes);
				buffer.add(bytes);
				length += avail;
			}
			byte[] result = new byte[length];
			int cursor = 0;
			for (byte[] b : buffer) {
				System.arraycopy(b, 0, result, cursor, b.length);
				cursor += b.length;
			}
			return result;
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private MediaFileType getFileType(String fileName) throws Exception {
		String[] parts = fileName.split(".");
		String suffix = parts[parts.length - 1];
		if (suffix.equalsIgnoreCase("jpg") || suffix.equalsIgnoreCase("jpeg"))
			return MediaFileType.JPEG;
		else if (suffix.equalsIgnoreCase("gif"))
			return MediaFileType.GIF;
		else
			throw new Exception(String.format("対応していない拡張子です。（%s）", suffix));
	}

	private MediaAdFormat getFormat(int width, int height) throws Exception {
		if (width == 728 && height == 90)
			return MediaAdFormat.IAB_UAP_LEADER_BOARD;
		else if (width == 300 && height == 50)
			return MediaAdFormat.IAB_STANDARD_BANNER;
		else if (width == 300 && height == 250)
			return MediaAdFormat.IAB_UAP_MEDIUM_RECTANGLE;
		else if (width == 468 && height == 60)
			return MediaAdFormat.BANNER;
		else if (width == 160 && height == 600)
			return MediaAdFormat.IAB_UAP_WIDE_SKYSCRAPER;
		else if (width == 320 && height == 100)
			return MediaAdFormat.YJ_SMART_DOUBLE_BANNER;
		else
			throw new Exception(String.format("ファイルサイズが対応していません。（%dx%d）", width, height));
	}

	public MediaRecord make() {
		return media;
	}
}
