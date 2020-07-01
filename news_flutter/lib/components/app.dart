import 'package:flutter/material.dart';
import 'package:newsflutter/utils/utils.dart';
import 'package:newsflutter/values/values.dart';

import 'button.dart';

/// 透明背景 AppBar
Widget transparentAppBar({
  @required BuildContext context,
  Widget title,
  Widget leading,
  List<Widget> actions,
}) {
  return AppBar(
    backgroundColor: Colors.transparent,
    elevation: 0,
    title: Center(
      child: title,
    ),
    leading: leading,
    actions: actions,
  );
}

/// 第三方登录封装
Widget thirdPartyLogin() {
  return Container(
    width: duSetWidth(295),
    margin: EdgeInsets.only(bottom: duSetHeight(40)),
    child: Column(
      children: <Widget>[
        // title
        Text(
          "Or sign in with social networks",
          textAlign: TextAlign.center,
          style: TextStyle(
            color: primaryText,
            fontFamily: "Avenir",
            fontWeight: FontWeight.w400,
            fontSize: duSetFontSize(16),
          ),
        ),
        // 按钮
        Padding(
          padding: EdgeInsets.only(top: duSetHeight(20)),
          child: Row(
            children: <Widget>[
              btnFlatButtonBorderOnlyWidget(
                onPressed: () {},
                width: 88,
                iconFileName: "twitter",
              ),
              Spacer(),
              btnFlatButtonBorderOnlyWidget(
                onPressed: () {},
                width: 88,
                iconFileName: "google",
              ),
              Spacer(),
              btnFlatButtonBorderOnlyWidget(
                onPressed: () {},
                width: 88,
                iconFileName: "facebook",
              ),
            ],
          ),
        ),
      ],
    ),
  );
}
