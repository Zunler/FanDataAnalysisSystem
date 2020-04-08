## 使用

- 模拟数据

  需要模拟插入MySQL数据

  将FdasApplication修改成

  ```java
    public static void main(String[] args) {
          SpringApplication.run(FdasApplication.class, args);
         // 服务器启动后，启动一个线程模拟产生新的报警数据
          GenerateDataUtils mysqlUtils = new GenerateDataUtils();
          Thread thread = new Thread(mysqlUtils);
          thread.start();

    }
  ```

- websocket

  将resources/static/js下的myjs.js的websocket连接IP修改为localhost;服务器则修改为对应的IP地址

  ```js
  var webSocket = new WebSocket("ws://localhost:18080/websocket");
  ```

- 运行

  - 本地

    maven工具栏->spring-boot:run

  - 服务器

    1. maven工具栏->toggle "skip test"mode 跳过test

    2. maven lifeStyle：package

    3. scp到服务器自定义目录下

    4. 启动

       ```shell
        nohup java -jar fdas-0.0.1-SNAPSHOT.jar >fdas.log &
       ```

## 遇到问题

1. controller 无法渲染网页

   将@RestController改为@Controller，RestController只会返回字符串内容

2. Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required

   添加依赖，完整依赖见pom

3. Injection of autowired dependencies failed; nested exception is java.lang.NullPointerException

    注入autowired失败，其实就是配置websocket方式错误

   详情见websocket包下代码

4. failed: Error during WebSocket handshake: Unexpected response code: 404

   前端js报错，本地运行时使用的是localhost，部署到服务器后，外网访问，应该修改成服务器IP

5. 数据不够一小时，曲线图无法显示

   一小时内每十分钟的报警数量曲线，需要获取六段数据，当数据不足一小时是无法显示完整的曲线图。

   修改为只显示当前含有的数据，即若只有前二十分钟数据，就曲线只显示两个点，0-10，10-20的数据

6. org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'serverEndpointExporter' defined in class path resource

   打包的时候跳过test，因为spring boot内带tomcat，tomcat中的websocket会有冲突出现问题，因此跳过test编译打包。

   Idea侧边maven工具栏，闪电标志（toggle‘Skip test’ mode）

