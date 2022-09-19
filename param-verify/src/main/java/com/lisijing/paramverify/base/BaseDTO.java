package com.lisijing.paramverify.base;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Author 李健新
 * @Date 2022/9/19
 * @Description
 */
public class BaseDTO {

    // 空校验

    @NotNull(message = "此属性不可为null")
    private String notNull;

    @Null(message = "此属性必须为null")
    private String checkNull;

    @NotBlank(message = "此属性不可为null不能是空格并且至少包含一个字符")
    private String notBlank;

    @NotEmpty(message = "此属性不可为null或空")
    private String notEmpty;

    @Email(message = "该属性必须是格式正确的电子邮件地址")
    private String email;

    // 布尔校验

    @AssertTrue(message = "此属性必须为true")
    private Boolean checkTrue;

    @AssertFalse(message = "此属性必须为false")
    private Boolean checkFalse;

    // 长度校验

    /**
     * Array,Collection,Map,String
     */
    @Size(min = 0, max = 1, message = "长度是否在给定的范围之内")
    private String checkSize;

    /**
     *  Validates that the annotated string is between min and max included.
     */
    @Length(min = 0, max = 1, message = "长度是否在给定的范围之内")
    private String checkLength;


    // 数值检查
    // 建议使用在Stirng,Integer类型，不建议使用在int类型上，因为表单值为“”时无法转换为int，但可以转换为Stirng为”“,Integer为null

    /**
     *  验证 Number 和 String 对象是否大等于指定的值
     */
    @Min(1)
    private Integer min;

    /**
     * 验证 Number 和 String 对象是否小等于指定的值
     */
    @Max(2)
    private Integer max;

    /**
     * 被标注的值必须不大于约束中指定的最大值. 这个约束的参数是一个通过BigDecimal定义的最大值的字符串表示.小数存在精度
     */
    @DecimalMin("1.1")
    private BigDecimal decimalMin;

    /**
     * 被标注的值必须不大于约束中指定的最大值. 这个约束的参数是一个通过BigDecimal定义的最大值的字符串表示.小数存在精度
     */
    @DecimalMax("1.2")
    private BigDecimal decimalMax;

    /**
     * 验证字符串是否是符合指定格式的数字，interger指定整数精度，fraction指定小数精度
     */
    @Digits(integer = 1, fraction = 2)
    private String digits;

    /**
     * 被指定的元素必须在合适的范围内
     */
    @Range(min=10000, max=50000, message="range.bean.wage")
    private String range;

    // 日期校验


    /**
     * 验证 Date 和 Calendar 对象是否在当前时间之前，验证成立的话被注释的元素一定是一个过去的日期
     */
    @Past
    private Date beforeDate;

    /**
     * 验证 Date 和 Calendar 对象是否在当前时间之后 ，验证成立的话被注释的元素一定是一个将来的日期
     */
    @Past
    private Date afterDate;

    /**
     * 验证是否是日期
     */
//    @FutureOrPresent
    private String checkData;

    // 正则校验

    @Pattern(regexp = "0?(13|14|15|17|18|19)[0-9]{9}")
    private String phone;

    public String getNotNull() {
        return notNull;
    }

    public void setNotNull(String notNull) {
        this.notNull = notNull;
    }

    public String getCheckNull() {
        return checkNull;
    }

    public void setCheckNull(String checkNull) {
        this.checkNull = checkNull;
    }

    public String getNotBlank() {
        return notBlank;
    }

    public void setNotBlank(String notBlank) {
        this.notBlank = notBlank;
    }

    public String getNotEmpty() {
        return notEmpty;
    }

    public void setNotEmpty(String notEmpty) {
        this.notEmpty = notEmpty;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getCheckTrue() {
        return checkTrue;
    }

    public void setCheckTrue(Boolean checkTrue) {
        this.checkTrue = checkTrue;
    }

    public Boolean getCheckFalse() {
        return checkFalse;
    }

    public void setCheckFalse(Boolean checkFalse) {
        this.checkFalse = checkFalse;
    }

    public String getCheckSize() {
        return checkSize;
    }

    public void setCheckSize(String checkSize) {
        this.checkSize = checkSize;
    }

    public String getCheckLength() {
        return checkLength;
    }

    public void setCheckLength(String checkLength) {
        this.checkLength = checkLength;
    }

    public Integer getMin() {
        return min;
    }

    public void setMin(Integer min) {
        this.min = min;
    }

    public Integer getMax() {
        return max;
    }

    public void setMax(Integer max) {
        this.max = max;
    }

    public BigDecimal getDecimalMin() {
        return decimalMin;
    }

    public void setDecimalMin(BigDecimal decimalMin) {
        this.decimalMin = decimalMin;
    }

    public BigDecimal getDecimalMax() {
        return decimalMax;
    }

    public void setDecimalMax(BigDecimal decimalMax) {
        this.decimalMax = decimalMax;
    }

    public String getDigits() {
        return digits;
    }

    public void setDigits(String digits) {
        this.digits = digits;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public Date getBeforeDate() {
        return beforeDate;
    }

    public void setBeforeDate(Date beforeDate) {
        this.beforeDate = beforeDate;
    }

    public Date getAfterDate() {
        return afterDate;
    }

    public void setAfterDate(Date afterDate) {
        this.afterDate = afterDate;
    }

    public String getCheckData() {
        return checkData;
    }

    public void setCheckData(String checkData) {
        this.checkData = checkData;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
