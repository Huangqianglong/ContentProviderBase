# ContentProviderBase
数据库和ContentProvider的基本使用
授权 ：AUTHORITIES = "com.hql.provider"
第三方查询Uri :CONTENT_URI = Uri.parse("content://" + AUTHORITIES);
实现Provider的几个关键接口：query insert delete update，可在其中添加getContentResolver().notifyChange实现数据变更通知
第三方通过contentResolver.query(CONTENT_URI，XXX) contentResolver.insert(CONTENT_URI,xxxx)等方法查询操作数据库
end