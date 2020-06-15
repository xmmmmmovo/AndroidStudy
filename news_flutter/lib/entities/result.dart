import 'package:flutter/material.dart';

class Result<T> {
  final int code;
  final String msg;
  final T data;

  Result({@required this.code, @required this.msg, @required this.data});

  factory Result.fromJson(Map<String, dynamic> json) =>
      Result(code: json["code"], msg: json["msg"], data: json["data"]);

  Map<String, dynamic> toJson() => {"code": code, "msg": msg, "data": data};
}
