# JSR303
JSR303 是一套JavaBean参数校验的标准，它定义了很多常用的校验注解，我们可以直接将这些注解加在我们JavaBean的属性上面，就可以在需要校验的时候进行校验了。

|注解|说明|
|--|--|
|@Null|注解元素必须是空|
|@NotNull|注解元素必须是非空|
|@NotBlank|注解元素不能是空格并且至少包含一个字符|
|@NotEmpty|注解元素不能为null或空|
|@Length|验证字符串大小是否在指定范围内|
|@Email|该字符串必须是格式正确的电子邮件地址。|
|@Pattern|带注释的必须匹配指定的正则表达式。正则表达式遵循 Java 正则表达式约定|
|@Size|验证元素大小是否在指定范围内 (Array、Collection、Map、String)|
|@Past|带注释的元素必须是过去的瞬间、日期或时间。|
|@Future|带注释的元素必须是未来的瞬间、日期或时间。|
|@FutureOrPresent|注释元素必须是当前或未来的瞬间、日期或时间。|
|@PastOrPresent|带注释的元素必须是过去或现在的瞬间、日期或时间。|
|@Max|带注释的元素必须是一个数字，其值必须小于或等于指定的最大值。|
|@Min|带注释的元素必须是一个数字，其值必须大于或等于指定的最小值。|
|@Positive|被注解的元素必须是整数|
|@PositiveOrZero|被注解元素必须是正数或0|
|@Digits|带注释的元素必须是可接受范围内的数字|
|@DecimalMax|带注释的元素必须是一个数字，其值必须小于或等于指定的最大值。|
|@DecimalMin|带注释的元素必须是一个数字，其值必须大于或等于指定的最小值。|
|@AssertTrue|被注释的元素必须为true|
|@AssertFalse|被注释的元素必须为false|

Hibernate validator 在JSR303的基础上对校验注解进行了扩展。 ![hibernate-validator官方文档](https://docs.jboss.org/hibernate/stable/validator/reference/en-US/html_single/#validator-gettingstarted-createproject)

Hibernate Validator 是 Jakarta Bean Validation 的参考实现。

```xml
       <!--JSR303依赖包-->
        <dependency>
            <groupId>javax.validation</groupId>
            <artifactId>validation-api</artifactId>
            <version>2.0.1.Final</version>
        </dependency>
        
        <!--hibernate-validator依赖包，包含了JSR303的依赖包-->
        <dependency>
            <groupId>org.hibernate.validator</groupId>
            <artifactId>hibernate-validator</artifactId>
            <version>6.0.18.Final</version>
        </dependency>
```
或

```xml
<dependency>
   <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

# @Validated、@Valid区别
@Validated：
- Spring提供的
- 支持分组校验
- 可以用在类型、方法和方法参数上。但是不能用在成员属性（字段）上
- 由于无法加在成员属性（字段）上，所以无法单独完成级联校验，需要配合@Valid


@Valid：
- JDK提供的（标准JSR-303规范）
- 不支持分组校验
- 可以用在方法、构造函数、方法参数和成员属性（字段）上
- 可以加在成员属性（字段）上，能够独自完成级联校验

总结： @Validated用到分组时使用，一个学校对象里还有很多个学生对象需要使用@Validated在Controller方法参数前加上，@Valid加在学校中的学生属性上，不加则无法对学生对象里的属性进行校验！

```java
public class School{

    @NotBlank
    private String id;
    
    @Valid                // 需要加上，否则不会验证student类中的校验注解
    @NotNull 			  // 需要触发该字段的验证才会进行嵌套验证。
    private List<Student> list;
}
```

```java
public class Student {

    @NotBlank
    private String id;
    private String name;
    private int age;
    
}
```

```java
@PostMapping("/test")
public Result test(@Validated @RequestBody School school){}
```


# 自定义校验

- 定义注解 （ListValue）
- 定义参数校验器 （ListValueConstraintValidator）
    - 1个注解对应一个参数校验器
    - 1个注解对应多个参数校验器（根据参数类型不同）


