import java.io.IOException;

import jpcap.*;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;

public class  JacapPacket {

    public static void main(String[] args) {
        /*--------------	第一步绑定网络设备       --------------*/
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();

        for (NetworkInterface n : devices) {
            System.out.println(n.name + "     |     " + n.description);
            for (NetworkInterfaceAddress a : n.addresses) {
                System.out.println("ip:" + a.address);
            }

        }

        System.out.println("-------------------------------------------");

        JpcapCaptor jpcap = null;
        int caplen = 2000;
        boolean promiscCheck = true;

        try {
            jpcap = JpcapCaptor.openDevice(devices[1], caplen, promiscCheck, 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        /*----------第二步抓包-----------------*/

        int i = 0;

        while (i < 10) {
            Packet packet = jpcap.getPacket();
            //IPPacket ：这个类描述了IP包，继承了Packet类，支持IPv4和IPv6
            //Packet ：这个类是所有被捕获的数据包的基类
            if (packet instanceof IPPacket && ((IPPacket) packet).version == 4) {
                i++;
                IPPacket ip = (IPPacket) packet;//强转
                System.out.println(ip.toString());
                System.out.println("版本：IPv4");
                System.out.println("优先权：" + ip.priority);
                System.out.println("区分服务：最大的吞吐量： " + ip.t_flag);
                System.out.println("区分服务：最高的可靠性：" + ip.r_flag);
                System.out.println("长度：" + ip.length);
                System.out.println("标识：" + ip.ident);
                System.out.println("DF:Don't Fragment: " + ip.dont_frag);
                System.out.println("NF:Nore Fragment: " + ip.more_frag);
                System.out.println("片偏移：" + ip.offset);
                System.out.println("生存时间：" + ip.hop_limit);

                //常见协议对应的字段
                //IP协议在传输数据包时，将数据报文分为若干分片进行传输，并在目标系统中进行重组。
                //以太网环境中可传输最大IP报文大小为1500字节
                //如果收到的包IP头中Fragmentation Flags为0且有UDP字段，则未分片。
                //如果收到的包IP头中Fragmentation Flags为1且有UDP字段，则为第一片。
                //如果收到的包IP头中Fragmentation Flags为1且无UDP字段，则为中间片。
                //如果如果收到的包IP头中Fragmentation Flags为0且无UDP字段，则为最后一片。
                // P分片原理及分析分片和重新组装的过程对传输层是透明的，其原因是当IP数据报进行分片之后，
                // 只有当它到达下一站时，才可进行重新组装，且它是由目的端的IP层来完成的。分片之后的数据报根据需要也可以再次进行分片

                String protocol = "";
                switch (new Integer(ip.protocol)) {
                    case 1:
                        protocol = "ICMP";
                        break;
                    case 2:
                        protocol = "IGMP";
                        break;
                    case 6:
                        protocol = "TCP";
                        break;
                    case 8:
                        protocol = "EGP";
                        break;
                    case 9:
                        protocol = "IGP";
                        break;
                    case 17:
                        protocol = "UDP";
                        break;
                    case 41:
                        protocol = "IPv6";
                        break;
                    case 89:
                        protocol = "OSPF";
                        break;
                    default:
                        break;
                }
                if (packet instanceof IPPacket) {
                    System.out.println("协议：IP");
                    System.out.println("源IP " + ip.src_ip.getHostAddress());
                    System.out.println("目的IP " + ip.dst_ip.getHostAddress());
                    System.out.println("源主机名： " + ip.src_ip);
                    System.out.println("目的主机名： " + ip.dst_ip);
                    System.out.println("------------------------------------------------------------------------------");
                }
                if (packet instanceof IPPacket == false) {
                    System.out.println("该数据包中无IP协议!");
                }
                System.out.println("------------------------------------------------------------------------------");
                // 输出相关数据
                if (packet instanceof TCPPacket) {
                    TCPPacket tcp = (TCPPacket) packet;
                    System.out.println("协议：TCP");
                    System.out.println("源端口：" + tcp.src_port);
                    System.out.println("目的端口：" + tcp.dst_port);
                    System.out.println("序号：" + tcp.sequence);
                    System.out.println("确认号：" + tcp.ack_num);
                    System.out.println("数据偏移：" + tcp.offset);
                    System.out.println("紧急URG：" + tcp.urg);
                    System.out.println("确认ACK：" + tcp.ack);
                    System.out.println("推送PSH：" + tcp.psh);
                    System.out.println("复位RST：" + tcp.rst);
                    System.out.println("同步SYN：" + tcp.syn);
                    System.out.println("终止FIN：" + tcp.fin);
                    System.out.println("窗口：" + tcp.window);
                    System.out.println("紧急指针：" + tcp.urgent_pointer);
                    System.out.println("------------------------------------------------------------------------------");
                }
                if (packet instanceof TCPPacket == false) {
                    System.out.println("该数据包中无TCP协议!");
                }
                System.out.println("------------------------------------------------------------------------------");
                if (packet instanceof UDPPacket) {
                    UDPPacket udp = (UDPPacket) packet;
                    System.out.println("协议：UDP");
                    System.out.println("源端口：" + udp.src_port);
                    System.out.println("目的端口：" + udp.dst_port);
                    System.out.println("长度：" + udp.length);
                }
                System.out.println("------------------------------------------------------------------------------");
                if (packet instanceof UDPPacket == false) {
                    System.out.println("该数据包中无UDP协议!");
                }
            }
        }
    }
}