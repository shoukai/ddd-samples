# 领域驱动示例

示例需求参照张逸的专栏《领域驱动设计实践（战术篇）》示例思路，重新描述了部分需求内容，示例代码为自行发挥

## 业务需求

员工系统主要包括：
1. 员工信息管理；
2. 员工工作日志；

### 1. 员工信息管理

员工信息管理由人事专员（人事专员同样为员工，但是人事专员信息不在当前系统维护，当前系统定义为外部集团员工信息管理系统）负责办理员工入职和离职手续，维护员工信息和管理员工合同。

办理员工入职手续时，首先需要新增员工。在输入员工基本信息时，需要通过组织上下文（外部系统）选择部门

作为一家软件外包集团，员工的技能、语言能力与项目经验是必备信息，需要由人事专员手工输入。如果入职新员工来自人才储备库，可以将人才储备库中的信息直接作为入职员工的信息，即将候选人才直接“升级”为正式员工。这些信息也是生成员工简历的必要数据。

为了减轻市场人员的工作量，系统提供简历自动生成的功能。员工的项目经验包括入职前的项目经验，入职后参与的项目会作为项目经验的一部分自动添加到员工项目经验中。

员工入职后，需要和公司签订合同。人事专员需要在员工签订了合同之后，在系统中维护合同条款的基本信息，并上传合同附件。

员工若要离职，需要执行离职流程。为了简化业务，这里未考虑与工作流的集成，故而只需要人事专员直接办理员工离职手续即可。离职后，员工的状态被设置为“离职”状态。

### 2. 员工工作日报

公司制度要求员工每个工作日都要填写和提交工作日志。工作日志分为日报和项目日志。

填写日报时，可以保存为日报草稿，也可以直接提交。提交后的日报不允许再进行编辑。

日报草稿既可以编辑，也可以删除。如果工作日当天没有提交日报，且员工又没有请假，系统会根据设置的提醒时间发送邮件，提醒员工提交日报。

当员工作为项目成员认领了项目的任务时，可以为任务填写项目日志。项目任务的信息会自动成为项目日志内容的一部分，员工可以编辑项目日志的内容。

员工可以查看自己提交的工作日志，部门主管则可以查看该部门所有员工提交的工作日志，参与项目的成员可以查看当前项目的全部项目日志。

项目信息为项目管理系统进行管理，已经建设完成，可以为当前待开发系统提供接口，需要整理需求提到项目管理团队。


## 技术说明

### MyBatis-Plus

主页参考： * [MyBatis-Plus](https://mybatis.plus/)，示例参考： *[MyBatis-Plus Samples](https://github.com/baomidou/mybatis-plus-samples)

### Spring Test and Mock

示例参考： *[Testing in Spring Boot](https://www.baeldung.com/spring-boot-testing)

## 接口示例

### 新增员工

```shell script
curl --location --request POST 'localhost:8080/api/v1/employee/employee' \
--header 'Content-Type: application/json' \
--data-raw '{
	"name":"Test",
	"age":1,
	"email":"abc@abc.com",
	"employeeSkills":[
		{
			"skillId":1,
			"skillLevelId":4
		},
		{
			"skillId":4,
			"skillLevelId":7
		}	
	]
}'
```

结果：

```json
{
    "id":20
}
```

### 获取员工

```shell script
curl --location --request GET 'localhost:8080/api/v1/employee/employee?id=17' \
--header 'Content-Type: application/json' \
--data-raw '{
	"name":"Test",
	"age":1,
	"email":"abc@abc.com",
	"employeeSkills":[
		{
			"skillId":1,
			"skillLevelId":4
		},
		{
			"skillId":4,
			"skillLevelId":7
		}	
	]
}'
```

结果

```json
{
    "id": 17,
    "name": "Test",
    "email": "abc@abc.com",
    "skills": [
        {
            "skillId": 1,
            "skillCategory": "develop",
            "skillName": "Java",
            "skillLevelId": 4,
            "skillLevelName": "资深",
            "skillLevelRequirement": "5-8年"
        },
        {
            "skillId": 4,
            "skillCategory": "office",
            "skillName": "excel",
            "skillLevelId": 7,
            "skillLevelName": "高级",
            "skillLevelRequirement": "函数及制图"
        }
    ]
}
```

### 获取员工摘要

```shell script
curl --location --request GET 'localhost:8080/api/v1/employee/summary?id=17' \
--header 'Content-Type: application/json' \
--data-raw '{
	"name":"Test",
	"age":1,
	"email":"abc@abc.com",
	"employeeSkills":[
		{
			"skillId":1,
			"skillLevelId":4
		},
		{
			"skillId":4,
			"skillLevelId":7
		}	
	]
}'
```

结果：

```json
{
    "id": 17,
    "name": "Test",
    "email": "abc@abc.com"
}
```

# TODO

* (done) employee get detail
* (done) employee get summary 
* employee add junit
* work log db
* work log entity
* work log save
* work log get and query employee

# 示例参考

* [领域驱动设计实践（战术篇）](https://gitbook.cn/gitchat/column/5cbed2f6f00736695f3a8699)
* [员工上下文的领域建模](https://github.com/agiledon/eas-ddd)
* [MyBatis-Plus](https://mybatis.plus/)

