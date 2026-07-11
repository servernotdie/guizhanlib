# GuizhanLib

[![Maven Central](https://img.shields.io/maven-central/v/net.guizhanss/guizhanlib-all.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22net.guizhanss%22%20AND%20a:%22GuizhanLib%22)

A Java library that helps developing Slimefun addons.  
Một thư viện Java giúp phát triển addon cho Slimefun.

## Usage | Cách sử dụng

### Maven

Add `guizhanlib-all` (which includes all sub modules) or **the modules you need** as dependency:  
Thêm `guizhanlib-all` (bao gồm tất cả các module con) hoặc **các module bạn cần** làm dependency:

```
    <dependency>
        <groupId>net.guizhanss</groupId>
        <artifactId>guizhanlib-all</artifactId>
        <version>REPLACE WITH VERSION</version>
        <scope>compile</scope>
    </dependency>
```

You will need to relocate the library classes if you use it for addon development.  
Trong `build`, bạn cần di chuyển (relocate) GuizhanLib vào package của mình, để tránh xung đột với GuizhanLib được sử dụng trong các plugin khác
（Nếu đã có cấu hình `maven-shade-plugin`, chỉ cần thêm phần relocation:

```
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.3.0</version>

                <configuration>
                    <!-- Add the following field to remove all unused classes and reduce the size of generated jar file. Not required, but recommended  -->
                    <!-- Bạn có thể thêm dòng dưới đây để loại bỏ tất cả các class không sử dụng trong thư viện, giúp giảm kích thước jar tạo ra, không bắt buộc, nhưng khuyến khích bật -->
                    <minimizeJar>true</minimizeJar>
                    <relocations>
                        <!-- IMPORTANT: add the following relocation -->
                        <!-- Quan trọng: bạn cần thêm phần relocation (di chuyển) dưới đây vào pom.xml của bạn -->
                        <relocation>
                            <pattern>net.guizhanss.guizhanlib</pattern>
                            <shadedPattern>(YOUR PACKAGE NAME HERE).guizhanlib</shadedPattern>
                        </relocation>
                    </relocations>

                    <filters>
                        <filter>
                            <artifact>*:*</artifact>
                            <excludes>
                                <exclude>META-INF/*</exclude>
                            </excludes>
                        </filter>
                    </filters>
                </configuration>

                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                    </execution>
                </executions>
            </plugin>
        </plugins>
```

## Changelog | Nhật ký thay đổi

[Changelog](/CHANGELOG.md)

## Này bản fork từ upstream của nhóm dev người TQ xong dịch :D
Credit: 
---
[Craft233MC](https://github.com/Craft233MC/guizhanlib)