# GeneralFullTools
通用小工具V1.0
GeneralTools 工具
1、编码
1.1 ASCII编码
实现细节：a:97  A:65  
实现原理：将字符串拆分为字符后转换为int类型得到。
涉及知识：1 Java在idea中可以选择默认的编码格式，这里为utf-8：字母占一个字节，汉字占三个字节。可以使用 "".getBytes()来验证此猜想，返回3。其中 getBytes() 是将unicode 转换为操作系统（idea）默认的格式的字节数组。
System.out.println("中".getBytes().length);

1.2 UNICOIDE编码
实现细节：Integer.toHexString(c)  c为char类型的单个字符。 这里的一个字符应该用两个字节来表示
实现原理：直接获取字符串中的每个字符，并将每个字符进行hex16进制转化即可，因为内存中进行运算统一使用Unicode编码。解码是复制粘贴的没明白
涉及知识：计算机内部默认使用Unicode编码方式，如果编译器使用其他编码方式，则通过getByte()获取到的是编译器的编码方式，所以不能通过这种方式获取内存编码方式。

1.3 UTF-8编码
实现细节：首先通过getByte("utf-8")转换为utf-8形式的字节码，然后进行字符转换
https://www.coderxing.com/java-string-conv-principle.html 
https://blog.csdn.net/u013905744/article/details/74452012/ 

1.4 GBK编码
实现细节：类比于utf-8编码。下面为GBK编码对照表   汉字一般是两个字节
https://blog.csdn.net/u013905744/article/details/74452012/ 


1.5 URLCODING编码
实现细节：需要传入两个参数：待编码数、编码形式（gbk\utf-8）
实现原理：url编码针对的为非字母与数字，在网络传输中都需要进行url编码，但是此编码通过浏览器决定，而不同的浏览器编码方式不尽相同，导致url编码异常混乱，解决方法：js端统一。说白了url编码也就是不同的编码方式+%的组合



1.6 BASE64编码
实现细节：jdk1.8中自带此编码方式，Base64.getEncoder().encodeToString(byte[] )即可。
https://www.jianshu.com/p/b60d1b0f49e2

1.7 HEX编码
实现细节：Commons Codec包下的Hex类的静态方法encodeHexString()/decodeHex()
https://www.jianshu.com/p/57c4e8d3f035
base64与hex编码的目的都是将字节数组转化为字符串的表示形式。
1.8 HTML编码
https://github.com/lq920320/blogs/issues/9  
实现细节：使用commons-text包下的StringEscapeUtils类的静态方法escapeHtml4/unescapeHtml4。


2、计算机组成原理
2.1 进制转换
2.2 原码反码补码

3 加解密
3.1 md5+sha1

3.2 AES+(3)DES
1 https://www.cnblogs.com/nangongyibin/p/10391691.html  对称加解密工作模式与填充模式介绍
两种加解密算法默认使用ECB/PKCS5Padding的模式
https://www.jianshu.com/p/f8cd7391d641  更加详细的介绍

2 https://www.cnblogs.com/xiaoliu66007/p/4687803.html 道出了两种加密方式不能使用7的原因以及解决方法  Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
完美解决：DES与AES都可以使用7填充。
3 工作模式：5种工作模式都可以使用，只不过ECB并行模式不能使用iv。
4 3种加密方式的Java代码实现方式大同小异。

3.3 RSA


4 功能待定区
4.1 截屏工具
4.2 web服务探索工具

5 结束区
5.1 工具屏幕居中显示

5.2 加入代码混淆机制

