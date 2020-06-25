import 'dart:convert';

import 'package:shared_preferences/shared_preferences.dart';

/*
* 存储工具类
* */
class StoreUtils {
  static final _singleton = new StoreUtils._internal();
  static SharedPreferences _prefs;

  factory StoreUtils() {
    return _singleton;
  }

  StoreUtils._internal();

  static Future<void> init() async {
    if (_prefs == null) {
      _prefs = await SharedPreferences.getInstance();
    }
  }

  /// 设置 json 对象
  Future<bool> setJSON(String key, dynamic jsonVal) {
    String jsonString = jsonEncode(jsonVal);
    return _prefs.setString(key, jsonString);
  }

  /// 获取 json 对象
  dynamic getJSON(String key) {
    String jsonString = _prefs.getString(key);
    return jsonString == null ? null : jsonDecode(jsonString);
  }
}
