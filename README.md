# EduShare QA - 大学生线上学习资源共享与问答系统
## 一、项目描述

随着在线教育的快速发展，传统课堂答疑模式已无法满足学生多样化的学习需求，因此本项目致力于构建一个集课程管理、问题解答、资源共享于一体的智能化答疑平台。

通过实际项目开发，深入理解Spring Boot的核心概念、自动配置、依赖注入等特性；学习MyBatis数据持久化技术：掌握MyBatis的配置、Mapper接口开发、动态SQL等数据库操作技术

理解前后端分离架构：学习并实践RESTful API设计规范，掌握前后端数据交互方式；掌握用户认证与授权机制：实现JWT令牌认证，学习拦截器在权限控制中的应用。

学习文件上传与云存储技术：集成阿里云OSS实现资源文件的上传和管理；培养项目开发综合能力：包括需求分析、系统设计、编码实现、测试调试等全流程开发能力。需求分析与系统设计：学习从用户需求到系统架构的设计过程；模块化开发：实践面向对象设计原则。

## 二、团队成员

- 周琪皓：架构设计、后端开发

- 简川淋：后端开发

- 张昊扬：前端开发

- 陆俊杰：前端开发

- 指导教师：刘欢

## 三、团队分工

### 后端团队（简川淋、周琪皓）

- 搭建 Spring Boot + MyBatis 架构，实现 MVC 分层开发

- 开发 RESTful API，处理用户认证（JWT）、数据持久化

- 集成阿里云 OSS，实现文件上传与云存储

- 负责数据库设计与动态 SQL 实现

### 前端团队（张昊扬、陆俊杰）

- 基于 Vue 3 + Element Plus 构建前端页面

- 实现路由管理、状态管理与组件化开发

- 开发交互功能（分页、搜索、表单验证等）

- 完成前后端数据对接与响应式布局适配

## 四、基本设计思路

采用前后端分离 + MVC 架构，后端处理业务逻辑与数据存储，前端负责用户交互。基于角色权限控制（学生 / 教师 / 管理员），使用 MySQL 存储核心数据，支持资源与问答的搜索、分页功能。

### 技术选型

#### 开发环境：

- 操作系统：Windows 11

#### 前端

- Visual Studio Code、Vue 3、Element Plus、Vue Router、Pinia、Fetch API、Vite

#### 后端

- IntelliJ IDEA 2024.1、Spring Boot 3.5.6、MyBatis 3.0.5、Maven 3.9.4、JWT、阿里云 OSS

#### 版本控制：

- Git + GitHub

### 安装与运行

1. 克隆仓库：

   - 前端：https://github.com/3528706162-arch/EduShare-QA

   - 后端：https://github.com/3528706162-arch/EduShare-QA-Backend

2. 后端配置：修改application.yml数据库信息及阿里云 OSS 配置，执行命令：

   ```bash

   mvn clean package && java -jar target/edushare-qa-0.0.1-SNAPSHOT.jar

 ```

3. 前端配置：进入前端目录，执行命令：

   ```bash

   npm install

   npm run dev

   ```

4. 访问地址：

   - 前端：http://localhost:5173

   - 后端：http://localhost:8080

### 初始账号

1. 管理员：peterccll / 123456

2. 教师：JayChou / 123456

3. 学生：Siuperap / 050217

## 五、运行相关

### 生产环境部署

先建一个基本的springboot项目，把该模块克隆到项目下

1. 修改生产环境配置

   - 在 `application-prod.yml` 文件中配置生产数据库连接

   - 设置根目录

   - 设置日志级别

2. 常见问题

   - Q: Maven构建失败

     A: 检查JDK版本是否为17，确保网络连接正常下载依赖

   - Q: 数据库连接失败

     A: 检查MySQL服务是否启动，数据库名和密码是否正确

   - Q: 端口被占用

     A: 修改 `application.yml` 中的 `server.port` 配置

3. 开发说明

   - 项目使用Lombok，确保IDE安装了Lombok插件

   - 代码规范遵循Spring Boot最佳实践

   - 使用MyBatis进行数据库操作

### SQL语句

```sql

create table answers

(

    id          bigint auto_increment primary key,

    question_id bigint                              null,

    content     text                                not null,

    author_id   bigint                              null,

 created_at  timestamp default CURRENT_TIMESTAMP null,

    file_url    varchar(200)                        null,

    constraint answers_ibfk_1

 foreign key (question_id) references questions (id),

 constraint answers_ibfk_2

        foreign key (author_id) references users (id)

);



create index author_id

    on answers (author_id);



create index question_id

    on answers (question_id);

----------------------------------------------------------------------------------------------------------------------

create table classes

(

    id           int auto_increment comment '课程ID，自增主键'

        primary key,

    title        varchar(255)                        not null comment '课程标题',

    class_type   varchar(50)                         not null comment '课程类型（如：必修课、选修课、实验课等）',

    description  text                                null comment '课程描述',

    institute    varchar(100)                        not null comment '所属学院/机构',

    created_at   timestamp default CURRENT_TIMESTAMP null comment '创建时间',

    updated_at   timestamp default CURRENT_TIMESTAMP null on update CURRENT_TIMESTAMP comment '更新时间',

    teacher_name varchar(20)                         null

);

----------------------------------------------------------------------------------------------------------------------

create table questions

(

    id            bigint auto_increment

        primary key,

    title         varchar(200)                        not null,

    content       text                                not null,

    author_id     bigint                              null,

    created_at    timestamp default CURRENT_TIMESTAMP null,

    question_type varchar(20)                         null,

    file_url      varchar(200)                        null,

    tags          varchar(200)                        null,

    class_belong  varchar(20)                         null,

    is_solved     tinyint(1)                          null,

    constraint questions_ibfk_1

        foreign key (author_id) references users (id)

);



create index author_id

    on questions (author_id);

----------------------------------------------------------------------------------------------------------------------

create table resources

(

    id             bigint auto_increment

 primary key,

    title          varchar(200)                         not null,

    description    text                                 null,

 uploader_name  varchar(20)                          null,

    download_count int        default 0                 null,

    created_at     timestamp  default CURRENT_TIMESTAMP null,

    class_belong   varchar(20)                          null,

    tags           varchar(200)                         null,

    file_type      varchar(20)                          null,

    file_url       varchar(200)                         null,

    is_public      tinyint(1) default 1                 null

);



create index uploader_id

    on resources (uploader_name);

----------------------------------------------------------------------------------------------------------------------

create table teachers

(

    id           int auto_increment comment '教师ID，自增主键'

        primary key,

    name         varchar(255)                        not null comment '姓名',

    username     varchar(50)                         not null comment '用户名',

    email        varchar(255)                        not null comment '邮箱',

    password     varchar(32)                         null,

    phonenumber  varchar(255)                        not null comment '手机号',

    introduction text                                null comment '简介',

    title        varchar(100)                        not null comment '职称',

    created_at   timestamp default CURRENT_TIMESTAMP null comment '创建时间',

    classes_name varchar(200)                        null

);

----------------------------------------------------------------------------------------------------------------------

create table users

(

    id             bigint auto_increment primary key,

    username       varchar(50)                                                    not null,

    email          varchar(100)                                                   not null,

    password       varchar(255)                                                   not null,

    role           enum ('student', 'teacher', 'admin') default 'student'         null,

    phonenumber    varchar(11)                                                    null,

    created_at     timestamp                            default CURRENT_TIMESTAMP null,

    image_url      varchar(200)                                                   null,

    classes_choose varchar(200)                                                   null,

    constraint email

 unique (email),

    constraint username

        unique (username)

);

```
