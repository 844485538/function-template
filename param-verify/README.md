# JSR303
JSR303 是一套JavaBean参数校验的标准，它定义了很多常用的校验注解，我们可以直接将这些注解加在我们JavaBean的属性上面，就可以在需要校验的时候进行校验了。

｜注解｜说明｜
@NotNull	注解元素必须是非空
@NotBlank	注解元素不能是空格并且至少包含一个字符
@NotEmpty	注解元素不能为null或空
@Email	该字符串必须是格式正确的电子邮件地址。
@Null	注解元素必须是空
@Digits	带注释的元素必须是可接受范围内的数字
@Future	带注释的元素必须是未来的瞬间、日期或时间。
@FutureOrPresent	注释元素必须是当前或未来的瞬间、日期或时间。
@Past	带注释的元素必须是过去的瞬间、日期或时间。
@PastOrPresent	带注释的元素必须是过去或现在的瞬间、日期或时间。
@Max	带注释的元素必须是一个数字，其值必须小于或等于指定的最大值。
@Min	带注释的元素必须是一个数字，其值必须大于或等于指定的最小值。
@Pattern	带注释的 {@code CharSequence} 必须匹配指定的正则表达式。正则表达式遵循 Java 正则表达式约定
@Size	验证元素大小是否在指定范围内
@DecimalMax	带注释的元素必须是一个数字，其值必须小于或等于指定的最大值。
@DecimalMin	带注释的元素必须是一个数字，其值必须大于或等于指定的最小值。
@AssertTrue	被注释的元素必须为true
@AssertFalse	被注释的元素必须为false
@Positive	被注解的元素必须是整数
@PositiveOrZero	被注解元素必须是正数或0


# 基本校验


# 级联校验


# 自定义校验