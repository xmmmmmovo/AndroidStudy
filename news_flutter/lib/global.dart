import 'dart:io';

import 'package:flutter/material.dart';
import 'package:flutter/services.dart';
import 'package:newsflutter/entities/entities.dart';
import 'package:newsflutter/utils/utils.dart';
import 'package:newsflutter/values/values.dart';

class Global {
  /// 用户配置
  static UserResponseEntity profile = UserResponseEntity(
    accessToken: null,
  );

  /// 是否 release
  static bool get isRelease => bool.fromEnvironment("dart.vm.product");

  /// init
  static Future init() async {
    // 运行初始
    WidgetsFlutterBinding.ensureInitialized();

    // 工具初始
    await StoreUtils.init();
    HttpUtil();

    // 读取离线用户信息
    var _profileJSON = StoreUtils().getJSON(STORAGE_USER_PROFILE_KEY);
    if (_profileJSON != null) {
      profile = UserResponseEntity.fromJson(_profileJSON);
    }

    // http 缓存

    // android 状态栏为透明的沉浸
    if (Platform.isAndroid) {
      SystemUiOverlayStyle systemUiOverlayStyle =
          SystemUiOverlayStyle(statusBarColor: Colors.transparent);
      SystemChrome.setSystemUIOverlayStyle(systemUiOverlayStyle);
    }
  }

  // 持久化 用户信息
  static Future<bool> saveProfile(UserResponseEntity userResponse) {
    profile = userResponse;
    return StoreUtils()
        .setJSON(STORAGE_USER_PROFILE_KEY, userResponse.toJson());
  }
}
