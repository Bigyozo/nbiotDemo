# NBIOT智能路灯系统
## 简介
- SpringBoot + Redis + Netty 实现的nbiot路灯监控与远程控制服务端系统，通过netty实现非阻塞式udp Server,接收电信nbiot模块发送的udp包，通过Redis存储设备状态的消息列表，以及反向发信控制设备。

