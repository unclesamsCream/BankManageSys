# BankManageSys
暑假课程设计，银行业务管理系统

##数据库设计

###操作表
	账户余额
	卡号
	账户类型
	转入卡号
	转出卡号
	日期
	交易金额
	交易类型

	

###用户表

	账号（卡号）
	姓名
	身份证号
	账户类型
	余额
	存款利率
	密码（6位）
	家庭住址
	联系电话
	电子邮箱
	是否冻结


###柜员表

	操作账号
	密码开户权限
	销户权限
	修改客户信息权限
	客户信息显示权限
	查询权限

###管理员表
	
	账号
	密码


##log

###2016/8/31  

- 完成了数据库设计

###2016/9/1
- 考虑向operation中添加type，来指明这是什么操作
- 在写Model层的一些内容，用户表的函数都调试过了

###2016/9/3
- dao包里面的差不多写完了，还有action和view两层
