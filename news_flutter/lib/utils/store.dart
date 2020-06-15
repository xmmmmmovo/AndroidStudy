import 'package:localstorage/localstorage.dart';
import 'package:newsflutter/values/values.dart';

/*
* 存储工具类
* */
class StoreUtils {
  static final _singleton = new StoreUtils._internal();
  LocalStorage _storage;

  factory StoreUtils() {
    return _singleton;
  }

  StoreUtils._internal() {
    _storage = new LocalStorage(STORE_MASTER_KEY);
  }

  String getItem(String key) {
    return _storage.getItem(key);
  }

  Future<void> setItem(String key, String val) async {
    await _storage.setItem(key, val);
  }
}
