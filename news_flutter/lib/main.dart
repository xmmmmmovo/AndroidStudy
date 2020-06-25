import 'package:flutter/material.dart';
import 'package:newsflutter/global.dart';
import 'package:newsflutter/routes.dart';
import 'package:newsflutter/screens/welcome_page.dart';

void main() {
  // 初始化
  Global.init().then((value) => runApp(MyApp()));
}

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'news',
      routes: staticRoutes,
      debugShowCheckedModeBanner: false,
      home: WelcomePage(),
    );
  }
}
