## 参数解密、返回值加密

RequestEncryptAdvice 类拦截 注解RequestEncrypt 标记的方法，对方法入参进行解密。

ResponseDecryptAdvice 类拦截 注解ResponseDecrypt 标记的方法，对方法返回值进行加密。

## 记录接口调用详情

MethodFilter 使用AOP拦截所有Controller对入参及返回值进行记录。