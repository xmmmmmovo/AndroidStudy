class ErrorEntity implements Exception {
  int code;
  String message;

  ErrorEntity({this.code, this.message});

  @override
  String toString() {
    if (message == null) return "Exception";

    return "Exception: code=$code, message=$message";
  }
}
