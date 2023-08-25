package core.enums;

public enum ErrorCodeEnum {
    /**
     * 状态码及描述
     */
    OK(0, "success", "INFO"),
    UNKNOWN_FAIL(500, "服务器错误，请稍后再试", "ERROR"),

    // 用户端校验异常
    ACCESS_ERROR(10001, "用户端错误", "INFO"),
    USER_LOGIN_ERROR(10010, "请登录", "INFO"),
    USER_LOGIN_MERCHANT_ERROR(10011, "当前用户未选择商户", "ERROR"),
    USER_LOGIN_STARUS_ERROR(10012, "用户状态不可用", "ERROR"),
    USER_AUTH_ERROR(10020, "无访问权限，请联系管理员开通", "INFO"),

    USER_TYPE_SAAS_ERROR(10030, "您当前的订单核销均需在第三方平台操作，请前往相关后台进行查看或管理", "ERROR"),

    // 业务相关逻辑异常
    FILE_CONVERT_FREQUENCY_ERROR(41202, "导出任务正在进行中，请勿重复操作", "ERROR"),
    FILE_CONVERT_SIZE_EXCEED_ERROR(41203, "数据量超过单次导出上限，请缩小筛选范围后重试", "ERROR"),
    PAGE_DATA_ERROR(41204, "获取分页数据有误", "ERROR"),
    TIME_RANGE_ERROR(41205, "时间范围异常，请重新确认起止时间", "ERROR"),
    USER_NOT_EXIST_ERROR(41403, "用户不存在", "ERROR"),
    USER_INFO_NOT_EXIST_ERROR(41415, "获取用户信息失败, 请联系平台客服", "ERROR"),

    // 资金与银行卡管理状态码 42000~42099
    CASH_MANAGEMENT_ERROR(42000, "资金管理错误", "ERROR"),
    CASH_MANAGEMENT_GET_SUMMARY_INFO_ERROR(42001, "我的资金数据获取失败，请稍后再试", "ERROR"),
    CASH_MANAGEMENT_GET_BILL_INFO_ERROR(42002, "收支明细数据获取失败，请稍后再试", "ERROR"),
    CASH_MANAGEMENT_GET_SETTLEMENT_RECORD_ERROR(42003, "提现记录数据获取失败，请稍后再试", "ERROR"),
    CASH_MANAGEMENT_GET_BILL_FILE_ERROR(42004, "收支明细数据获取失败，请稍后再试", "ERROR"),
    CASH_MANAGEMENT_GET_BILL_TOTAL_ERROR(42005, "收支明细数据获取失败，请稍后再试", "ERROR"),
    CASH_MANAGEMENT_GET_BLOCK_INFO_ERROR(42006, "资金池异常提示信息获取失败，请稍后再试", "ERROR"),
    BANKCARD_MANAGEMENT_AUDITING(42050, "银行卡信息审核中", "ERROR"),
    BANKCARD_ACCOUNT_INFO_NOT_EXIST_ERROR(42051, "未查询到有效收款账户，请重新选择", "ERROR"),

    // 券码相关状态码 43000~43099
    COUPON_CODE_ERROR(43000, "商品券码有误，请重新核对", "ERROR"),
    COUPON_SERVER_ERROR(43001, "服务器错误，请稍后再试", "ERROR"),
    COUPON_MONEY_ERROR(43002, "资金池余额不足，暂不支持撤销验券", "ERROR"),
    COUPON_USER_OVERTIME_ERROR(43003, "该商品券码核销已超过1小时，无法撤销", "ERROR"),
    COUPON_ALREADY_CANCEL_ERROR(43004, "该商品券码已撤销核销，请勿重复操作", "ERROR"),
    COUPON_OVERTIME_ERROR(43005, "该商品券码已过期，失效不可用", "ERROR"),
    COUPON_ALREADY_REFUNDING_ERROR(43006, "该商品券码订单正在退款中，暂不可用", "ERROR"),
    COUPON_ALREADY_REFUNDED_ERROR(43007, "该商品券码订单已退款，失效不可用", "ERROR"),
    COUPON_USED_ERROR(43008, "该商品券码已核销，请勿重复操作", "ERROR"),
    COUPON_STATUS_UNKNOWN_ERROR(43009, "系统处理中，请稍后重新查询券码状态", "ERROR"),
    COUPON_SHOP_ERROR(43010, "非当前门店可用券码，请重新核对", "ERROR"),
    COUPONCODE_ISNOT_BELONG_MERCHANT_ERROR(43011, "券码不属于当前商户，请重新核对", "ERROR"),
    COUPONCODE_SHOP_NOT_MATCH_ERROR(43012, "券码不适用于当前门店，请提醒顾客核对信息", "ERROR"),
    COUPONCODE_CURRENTSHOP_NOT_MATCH_ERROR(43013, "券码不适用于当前门店，请至首页切换门店", "ERROR"),
    WRITEOFFSHOP_CURRENTSHOP_NOT_MATCH_ERROR(43014, "券码已在其它门店使用，请提醒顾客核对信息", "ERROR"),
    USER_HAS_NOT_SHOP(43015, "该用户没有管理的门店", "ERROR"),
    USER_HAS_NOT_SELECT_SHOP(43016, "该用户未选择门店", "ERROR"),
    USER_NO_AUTH_CANCEL_ERROR(43017, "非商家管理员无权限撤销核销", "ERROR"),

    // 商户入驻相关状态码 44000~44099，统一名称为商家
    MERCHANT_REGISTER_ERROR(44000, "商家入驻错误", "ERROR"),
    MERCHANT_PAYMENT_AUDIT_INFO_NOT_EXIST_ERROR(44001, "获取支付审核记录失败", "ERROR"),
    MERCHANT_PARAM_EMPTY(44002, "请求参数不能为空", "ERROR"),
    MERCHANT_ID_EMPTY(44003, "商户ID不能为空", "ERROR"),
    MERCHANT_ID_OR_OPERATOR_EMPTY(44004, "商户ID或操作人为空", "ERROR"),
    MERCHANT_ERROR(44005, "商户数据异常，请联系多利熊销售顾问", "ERROR"),
    MERCHANT_NOT_EXIST(44006, "商户不存在", "ERROR"),
    PASSPORT_UNBIND_MOBILE(44007, "检测到百度账号未绑定手机号，请绑定后重试！", "ERROR"),
    EXT_ID_EMPTY(44008, "独立结算账户ID不能为空", "ERROR"),
    ACCOUNT_TYPE_EMPTY(44009, "账户类型不能为空", "ERROR"),

    // 成员管理相关状态码 45000~45099
    MEMBER_SAME_MOBILE_ERROR(45001, "手机号已经被注册使用", "ERROR"),
    MEMBER_NAME_ERROR(45002, "名称仅支持汉字/数字/英文内容", "ERROR"),
    MEMBER_NAME_MAX_LENGTH_ERROR(45003, "成员名称至多可输入30个字符", "ERROR"),
    MEMBER_SAME_UID_ERROR(45004, "服务器错误，请稍后再试", "ERROR"),
    MEMBER_MEMBER_MAX_NUM_ERROR(45005, "商家成员数量已达上限", "ERROR"),
    MEMBER_NONEXIST_ERROR(45007, "该用户不存在", "ERROR"),
    MEMBER_SEARCH_NONEXIST_ERROR(45008, "未找到该用户，请重新输入", "ERROR"),
    MEMBER_BAIDU_PASS_NONEXIST_ERROR(45017, "该百度帐号不存在，请重试输入", "ERROR"),
    MEMBER_PARAMS_ERROR(45008, "服务器错误，请稍后再试", "ERROR"),
    MEMBER_PARAMS_UKEY_MOBILE_NULL_ERROR(45009, "服务器错误，请稍后再试", "ERROR"),
    MEMBER_ADD_PARAMS_MOBILE_ERROR(45010, "请输入正确的手机号", "ERROR"),
    MEMBER_CONDITIONAL_SEARCH_PARAMS_ERROR(45011, "搜索内容不能为空", "ERROR"),
    MEMBER_SEARCH_ALREADY_HAS_ERROR(45013, "该成员已被商户添加", "ERROR"),
    MEMBER_SEARCH_ALREADY_HAS_OTHER_ERROR(45014, "该成员已被其他商家添加，请重新输入", "ERROR"),
    MEMBER_SEARCH_NAME_ALREADY_HAS_ERROR(45015, "已存在相同名称，可在输入时区分，如：**", "ERROR"),
    MEMBER_ROLE_ERROR(45021, "服务器错误，请稍后再试", "ERROR"),
    MEMBER_UKEY_ERROR(45025, "服务器错误，请稍后再试", "ERROR"),
    MEMBER_UID_UNREGSTER_ERROR(45026, "当前用户还未在本平台注册", "ERROR"),


    MEMBER_ACCOUNT_NOT_BOUND_PHONE_ERROR(45030, "该帐号未绑定手机号，请重新输入", "ERROR"),
    MEMBER_PHONE_NOT_BOUND_ACCOUNT_ERROR(45031, "该手机号未与百度帐号绑定，请重新输入", "ERROR"),
    MEMBER_VERIFICATION_CODE_NULL_ERROR(45032, "服务器错误，请稍后再试", "ERROR"),
    MEMBER_VERIFICATION_UKEY_NULL_ERROR(45037, "请先发送验证码", "ERROR"),

    // APP 登录 & 切换门店 & 我的页面 相关错误
    MEMBER_SHOP_OWNER_SHIP_ERROR(45050, "该门店不属于当前商户", "ERROR"),
    MEMBER_COOKIE_SHOP_OWNER_SHIP_ERROR(45051, "该门店不属于当前商户", "ERROR"),

    // 订单管理相关状态码 46000~46099
    ORDER_SERVER_ERROR(46000, "服务器错误，请稍后再试", "ERROR"),
    ORDER_STAT_TIME_ERROR(46001, "时间范围异常，请重新确认起止时间", "ERROR"),
    ORDER_STATUS_ERROR(46002, "订单状态异常，请重新查询确认", "ERROR"),
    ORDER_ALREADY_REFUND_ERROR(46003, "订单已发起退款，请勿重复操作", "ERROR"),
    ORDER_SHOP_NOT_MATCH_ERROR(46004, "该商品不适用于当前门店，请提醒顾客核对信息", "ERROR"),
    ORDER_WRITEOFF_SHOP_NOT_MATCH_ERROR(46005, "该券码已在其它门店使用，请提醒顾客核对信息", "ERROR"),

    // 商家管理小程序相关状态码 47000~47099
    USER_UNAUTHORIZED_ACCESS_ERROR(47001, "用户无权限操作", "ERROR"),
    PARAMS_ERROR(47002, "服务器错误，请稍后再试", "ERROR"),
    USER_UNAUTHORIZED_LOGIN(47003, "用户无权限", "ERROR"),
    COUPONCODE_NOT_EXIST_ERROR(47004, "券码不存在", "ERROR"),
    SMARTAPP_SHOP_NOT_MATCH_ERROR(47005, "该商品不适用于当前门店，请提醒顾客核对信息", "ERROR"),
    SMARTAPP_WRITEOFF_SHOP_NOT_MATCH_ERROR(47006, "该券码已在其它门店使用，请提醒顾客核对信息", "ERROR"),
    SMARTAPP_COUPON_USER_OVERTIME_ERROR(47007, "该商品券码核销已超过1小时，无法撤销", "ERROR"),

    // 短信验证码
    SMS_CHECK_FAILED(48001, "验证码校验失败", "ERROR"),
    SMS_SEND_TIMES_CHECK_FAILED(48002, "一个手机号同一天时间只能发送5次验证码", "ERROR"),
    SMS_CHECK_SEND_CODE_FAILED(48005, "短信发送场景验证失败，请重新验证场景正确性", "ERROR"),

    SMS_SEND_REPEAT_CHECK_FAILED(48003, "验证码发送频率过快，请稍后再试", "ERROR"),
    SMS_CHECK_TIMES_FAILED(48004, "验证码校验次数超出限制，请重新发送", "ERROR"),
    SMS_CODE_HAS_CHECKED(48006, "验证码已失效，请重新发送", "ERROR"),
    SMS_CODE_HAS_EXPIRED(48007, "验证码已过期，请重新发送", "ERROR"),
    SMS_CODE_RATE_LIMIT(48008, "操作过于频繁，请稍后再试", "ERROR"),
    SMS_CODE_CHECK_NOT_MATCH(48009, "验证码错误，请重新输入", "ERROR"),
    SMS_CODE_CHECK_NOT_EXIT(48010, "请先发送验证码", "ERROR"),
    SMS_CODE_SEND_ERROR(48011, "服务器错误，请稍后再试", "ERROR"),

    // 商户入驻customer


    // 内部服务异常 52000~52099
    INTERNAL_FILE_CONVERT_ERROR(52001, "数据文件生成失败，请稍后再试", "ERROR"),
    INTERNAL_BOS_ERROR(52002, "数据文件生成失败，请稍后再试", "ERROR"),


    // app-合同相关异常
    APP_CONTRACT_UNSIGNED(60001, "有合同未签约，请先处理合同签约", "ERROR"),


    // app-包管理相关异常
    APP_PACKAGE_UPDATE_DATA_IN_ERROR_STATUS(70001, "app包管理在不允许更新的状态更新内容信息！", "ERROR"),
    APP_PACKAGE_UPDATE_STATUS_IN_ERROR_STATUS(70002, "app包管理在不允许扭转的变化下更新状态！", "ERROR");


    private Integer code;
    private String msg;
    private String errorLevel;

    ErrorCodeEnum(Integer code, String msg, String errorLevel) {
        this.code = code;
        this.msg = msg;
        this.errorLevel = errorLevel;
    }

    public static String getMsgByCode(Integer code) {
        ErrorCodeEnum[] values = ErrorCodeEnum.values();
        for (ErrorCodeEnum ec : values) {
            if (ec.code.equals(code)) {
                return ec.msg;
            }
        }
        return "";
    }

    public static String getErrorLevelByCode(int code) {
        ErrorCodeEnum[] values = ErrorCodeEnum.values();
        for (ErrorCodeEnum ec : values) {
            if (ec.code.equals(code)) {
                return ec.errorLevel;
            }
        }
        return "";
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public ErrorCodeEnum setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public String getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(String errorLevel) {
        this.errorLevel = errorLevel;
    }
}
