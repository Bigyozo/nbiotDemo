# NBIOT服务端系统
## 简介
- SpringBoot + Redis + Netty 实现的nbiot服务端系统，通过netty实现非阻塞式IO,接收树莓派上搭载的nbiot模块（BC95）发送的udp包，通过Redis的list数据结构存储设备消息，并实现反向发信控制设备功能。
- 支持https访问
- 采用Redis哨兵模式实现高可用性。

