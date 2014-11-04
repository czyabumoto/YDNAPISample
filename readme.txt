--------------------------------
【バージョン】
--------------------------------
Ver4.6.0

■変更履歴
-----------
2014/03/26:
- V4.6 プレイスメントターゲティングに対応しました。

2014/02/07：
- V4.6 類似ユーザターゲティングを追加しました。
- V4.6 セグメントターゲティングを追加しました。
- V4.6 フリークエンシ・コントロールを追加しました。
- V4.6 リーチフリークエンシレポートを追加しました。

2013/09/04:
- AccountAdProductSample, DictionarySample, SearchKeywordSampleを追加しました。
- Soap APIライブラリをJAX-WSに変更しました。

2013/05/28:
- V4 サイトリターゲティングに対応しました。

2013/02/27:
- V4 AdSample / MediaSampleのAdGroupAdServiceにbidを追加しました。
- V4 BulkDownloadSampleのgetBulkDownloadに画像の抽出条件を追加しました。
- V4 BulkUploadSampleのgetBulkUploadStatusのレスポンスに画像の処理件数を追加しました。
- V4 ReportDownloadSampleについて定期レポートに対応しました。

2012/12/03:
- V4 画像配信に対応しました。

2012/10/09:
- V4 BulkServiceのアップロードに対応しました。

2012/09/19:
- V4 BulkServiceのダウンロードに対応しました。

2012/09/05:
- V4 APIに対応しました。

2012/04/17:
- conf/api_config.propertiesファイルのproduction環境用LOCATIONの設定値をlocation.im.yahooapis.jpに変更しました。

--------------------------------
【概要】
--------------------------------
このサンプルプログラムは、Javaを使用して各APIを呼び出す処理サンプルです。
JAX-WSを使用してAPIを呼び出す形になっています。

--------------------------------
【内容物】
--------------------------------
■binディレクトリ
コンパイルされたサンプルプログラムの実行ファイルと、
Windows上で実行するためのバッチファイルが格納されています。

- run_sample.bat：Windows上でサンプルプログラムを実行するためのバッチファイルです。
- sample.jar    ：コンパイルされたサンプルプログラムがまとめたjarファイルです。



■confディレクトリ
サンプルプログラム実行時の各種設定を記述するプロパティファイルが格納されています。

- api_config.properties：各種IDを記述する設定ファイルです。


■srcディレクトリ
以下の各プログラムが格納されています。

・以下は直接実行できるサンプルプログラムです。

- AccountAdProductSample.java  ：AccountAdProductServiceによるアカウント商品一覧の参照処理のサンプルです。
- AccountSample.java           ：AccountServiceによるアカウント参照、更新処理のサンプルです。
- AdSample.java                ：CampaignService/AdGroupService/AdGroupAdService/AdGroupTargetServiceによる入稿処理のサンプルです。
- BalanceSample.java           ：BalanceServiceによるアカウント残高参照処理のサンプルです。
- BulkDownloadSample.java      ：BulkServiceによるダウンロード処理のサンプルです。
- BulkUploadSample.java        ：BulkServiceによるアップロード処理のサンプルです。
- DictionarySample.java        ：DictionaryServiceによる地域データ、審査否認理由、ターゲット設定用マスタデータ参照処理のサンプルです。
- DomainBlockSample.java       ：DomainBlockServiceによるブロックドメイン設定、参照処理のサンプルです。
- MasterDataSample.java        ：MasterDataServiceによるターゲット設定用マスタデータ参照処理のサンプルです。
- MediaSample.java             ：AdSample.javaにMediaServiceを加えた画像広告の入稿処理のサンプルです。
- ReportDownloadSample.java    ：ReportDefinitionService, ReportServiceを使用したレポートダウンロード処理のサンプルです。
- RetargetingSample.java       ：RetargetingTagService, RetargetingListServiceを使用したリターゲティング処理のサンプルです。
- SearchKeywordSample.java     ：SearchKeywordIdeaService,SearchKeywordListServiceを使用したサーチターゲティング処理のサンプルです。
- PlacementUrlSample.java      ：PlacementUrlIdeaService,PlacementUrlListServiceを使用したプレイスメントターゲティング処理のサンプルです。

・以下は各サンプルプログラムから利用されるクラスです。

- SoapUtils.java           ：LocationServiceを使用したリクエスト先の取得処理のサンプル及びその他共通処理です。
- jp/yahooapis/im/V4配下         ：JAX-WSを使用してWSDLから生成したスタブ、スケルトンクラス群です。


■downloadディレクトリ
ReportDownloadSample、BulkDownloadSample、BulkUploadSampleを実行した際に、
ダウンロードしたデータがファイルとして格納されるディレクトリです。

■uploadディレクトリ
MediaSampleやBulkUploadSampleでアップロードするファイルをあらかじめ格納しておくディレクトリです。


--------------------------------
【環境設定】
--------------------------------
Java環境を構築するために、以下をインストールしてください。

[Java (J2SE) 1.6]
http://www.oracle.com/technetwork/java/javase/downloads/index.html


confディレクトリ配下にあるapi_config.propertiesに各IDを記述します。

LOCATION            : リクエスト先毎にコメントアウトを外してください。
LICENSE             : APIライセンスを記述(必須)
APIACCOUNTID        : APIアカウントIDを記述(必須)
APIACCOUNTPASSWORD  : APIアカウントパスワードを記述(必須)
ONBEHALFOFACCOUNTID : 代行アカウントを記述(任意)
ONBEHALFOFPASSWORD  : 代行アカウントパスワードを記述(任意)
ACCOUNTID           : アカウントIDを記述(必須)


binディレクトリ配下にあるrun_sample.batの先頭に各パスを記述します。

■例：
set JAVA_HOME=C:\Java\jdk1.6.0
set SAMPLE_HOME=C:\Java\java_sample


--------------------------------
【実行】
--------------------------------
binディレクトリ配下のrun_sample.batファイルを実行します。
引数として、実行したいサンプルプログラムのクラス名を指定します。

■例：
---------------------------------------
cd C:\Java\java_sample
bin\run_sample.bat AccountAdProductSample
bin\run_sample.bat AccountSample
bin\run_sample.bat AdSample
bin\run_sample.bat BalanceSample
bin\run_sample.bat BulkDownloadSample
bin\run_sample.bat BulkUploadSample
bin\run_sample.bat DictionarySample
bin\run_sample.bat DomainBlockSample
bin\run_sample.bat MasterDataSample
bin\run_sample.bat MediaSample
bin\run_sample.bat ReportDownloadSample
bin\run_sample.bat RetargetingSample
bin\run_sample.bat SearchKeywordSample
bin\run_sample.bat PlacementUrlSample
---------------------------------------

データをダウンロードする処理を実行した場合には、
downloadディレクトリにファイルが格納されます。

データをアップロードする処理を実行する場合には
実行前にあらかじめuploadディレクトリ配下にアップロードしたい
ファイルをuploadディレクトリ配下に格納しておく必要があります。
サンプルプログラムごとにファイル名は固定です。

・MediaSampleの場合：SampleMedia.jpg
・BulkUploadSampleの場合：SampleBulkUpload.csv
