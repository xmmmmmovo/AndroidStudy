import 'package:newsflutter/entities/entities.dart';
import 'package:newsflutter/utils/utils.dart';

Future<UserResponseEntity> login({UserRequestEntity params}) async {
  var response = await HttpUtil().post('/user/login', params: params);
  return UserResponseEntity.fromJson(response);
}
