1. 在服务器上创建一个 baozi 文件夹
刘景亮 21:54:05
2. 在 baozi 文件夹中写一个 c 程序，这个程序输出一些东西（随便输出一些啥），并编译出来

刘景亮 21:54:32
3. 在 baozi 文件夹下创建一个 xiaohei 文件夹
4. 在 xiaohei 文件夹里创建一个 test.txt 文件，里面写一段话
5. xiaohei 文件夹下的 test.txt 移动到 baozi 文件夹下
涉及到的命令：ssh 链接服务器，cd 切换目录，vim 打开文件，mv 移动文件，mkdir 创建文件夹，touch 创建文件

//ssh 会把每个你访问过计算机的公钥(public key)都记录到本地(~/.ssh/known_hosts)
当下次访问相同计算机时，OpenSSH会核对公钥。如果公钥同，OpenSSH会发出警告，避免你受到DNS Hijack之类的攻击。
原因：一台主机上有多个Linux系统，会经常切换，那么这些系统使用同一IP，登陆过一次后就会把ssh信息记录在本地
的(~/.ssh/known_hsots)文件中，切换该系统再用ssh访问这台主机就会出现冲突警告。解决方案如下：
1、手动删除修改known_hsots里面的内容
2、修改配置文件~/.ssh/config，加上以下两行后，重启服务器
StrictHostKeyChecking no
UserKnownHostsFile/dev/null

主机密钥覆盖失败
在mac下的解决办法：ssh-keygen -R 139.159.254.242