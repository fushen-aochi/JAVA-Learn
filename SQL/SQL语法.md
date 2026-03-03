# SQL语法

> 学习网站：[SQL之母](https://sqlmother.yupi.icu/#/levels)

***

### 条件查询-where

where 子句的语法如下：

```sql
SELECT 列1, 列2, ...
FROM 表名
WHERE 条件;
```

现在，我们使用 "WHERE" 来筛选出库存小于等于 20 的产品：

```sql
-- SQL查询语句
select name, price, stock from products where stock <= 20;
```

***

### 条件查询-空值

空值表示该字段的值是未知的、不存在的或者没有被填写的。在SQL查询中，我们可以使用 "IS NULL" 和 "IS NOT NULL" 来判断字段是否为空值或非空值。

现在，我们使用 "IS NULL" 来查询出入职日期未填写的员工：

```sql
-- SQL查询语句
select name, age from employees where hire_date is null;
```

 ***

### 条件查询-模糊查询

在 LIKE 模糊查询中，我们使用通配符来代表零个或多个字符，从而能够快速地找到匹配的数据。

有如下 2 种通配符：

- 百分号（%）：表示任意长度的任意字符序列。
- 下划线（_）：表示任意单个字符。

现在，我们使用 LIKE 模糊查询来找出姓名（name）中包含关键字 "张" 的员工信息：

```sql
-- SQL查询语句
select name, age, position from employees where name like '%张%';
```

***

### 条件查询-逻辑运算

逻辑运算是一种在条件查询中使用的运算符，它允许我们结合多个条件来过滤出符合特定条件的数据。

在逻辑运算中，常用的运算符有：

- AND：表示逻辑与，要求同时满足多个条件，才返回 true。
- OR：表示逻辑或，要求满足其中任意一个条件，就返回 true。
- NOT：表示逻辑非，用于否定一个条件（本来是 true，用了 not 后转为 false）

现在，我们使用逻辑运算来找出姓名中包含关键字 "李" 且 年龄小于 30 岁的员工信息：

```sql
-- SQL查询语句
select name, age, salary from employees 
where name like '%李%' and age < 30;
```

***

### 条件查询-去重

在 SQL 中，我们可以使用 DISTINCT 关键字来实现去重操作。

```sql
-- SQL 查询语句
select distinct class_id from students;
```

除了按照单字段去重外，DISTINCT 关键字还支持根据多个字段的组合来进行去重操作，确保多个字段的组合是唯一的。

示例语法如下：

```sql
distinct 字段1, 字段2, 字段3, ...
```

***

### 基础语法-排序

在 SQL 中，我们可以使用 ORDER BY 关键字来实现排序操作。ORDER BY 后面跟上需要排序的字段，可以选择升序（ASC）或降序（DESC）排列。

```sql
-- SQL 查询语句 1
select name, age from students order by age asc;

-- SQL 查询语句 2
select name, score from students order by score desc;
```

在排序的基础上，我们还可以根据多个字段的值进行排序。当第一个字段的值相同时，再按照第二个字段的值进行排序，以此类推。

示例语法如下：

```sql
order by 字段1 [升序/降序], 字段2 [升序/降序], ...
```

***

### 截断和偏移

假设你有一张待办事项清单，上面有很多任务。当你每次只想查看其中的几个任务时，会怎么办呢？

1）你可以使用手指挡住不需要看的部分（即截断）

2）根据任务的编号，直接翻到需要查看的位置（即偏移）

在 SQL 中，我们使用 LIMIT 关键字来实现数据的截断和偏移。

```sql
-- LIMIT 后只跟一个整数，表示要截断的数据条数（一次获取几条）
select task_name, due_date from tasks limit 2;

-- LIMIT 后跟 2 个整数，依次表示从第几条数据开始、一次获取几条
select task_name, due_date from tasks limit 2, 2;
```

***

### 条件分支

条件分支 case when 是 SQL 中用于根据条件进行分支处理的语法。它类似于其他编程语言中的 if else 条件判断语句，允许我们根据不同的条件选择不同的结果返回。

使用 case when 可以在查询结果中根据特定的条件动态生成新的列或对现有的列进行转换。

使用条件分支 case when ，根据 name 来判断学生是否会说 RAP，并起别名为 can_rap。

```sql
SELECT
  name,
  CASE WHEN (name = '鸡哥') THEN '会' ELSE '不会' END AS can_rap
FROM
  student;
```

***

### 时间函数

在 SQL 中，时间函数是用于处理日期和时间的特殊函数。它们允许我们在查询中操作和处理日期、时间、日期时间数据，从而使得在数据库中进行时间相关的操作变得更加方便和灵活。

常用的时间函数有：

- DATE：获取当前日期
- DATETIME：获取当前日期时间
- TIME：获取当前时间

使用时间函数获取当前日期、当前日期时间和当前时间：

```sql
-- 获取当前日期
SELECT DATE() AS current_date;

-- 获取当前日期时间
SELECT DATETIME() AS current_datetime;

-- 获取当前时间
SELECT TIME() AS current_time;
```

***

### 函数 - 字符串处理

1）使用字符串处理函数 UPPER 将姓名转换为大写：

```sql
-- 将姓名转换为大写
SELECT name, UPPER(name) AS upper_name
FROM employees;
```

2）使用字符串处理函数 LENGTH 计算姓名长度：

```sql
-- 计算姓名长度
SELECT name, LENGTH(name) AS name_length
FROM employees;
```

3）使用字符串处理函数 LOWER 将姓名转换为小写：

```sql
-- 将姓名转换为小写并进行条件筛选
SELECT name, LOWER(name) AS lower_name
FROM employees;
```

***
