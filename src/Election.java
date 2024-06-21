import javax.swing.JOptionPane;
import java.awt.Frame;

class Election {

    InterfaceExecution IE;
    NetworkTopology net;
    int root;

    /**
     * 
     */
    Election(NetworkTopology Net, InterfaceExecution ie) {
        IE = ie;
        net = Net;
        int i = ROOTelection();
        if (i == 0) {
            System.out.println("遇到错误退出了");
            return;
        }
        Relection();
        Delection();
    }

    /**
     * 根桥选举
     * 比较pri和mac地址
     */
    int ROOTelection() {

        if (net.Example == 1) {

            if (!(net.switch11.pri > 0 && net.switch11.pri < 61440 && net.switch12.pri > 0
                    && net.switch12.pri < 61440 && net.switch13.pri > 0 && net.switch13.pri < 61440
                    && net.switch14.pri > 0
                    && net.switch14.pri < 61440)) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的优先级配置!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }
            String mac = "";
            int sectionMAC = 0;
            int i = compareMacAddresses(net.switch11.mac, net.switch12.mac);
            if (i < 0) {
                mac = net.switch11.mac;
                sectionMAC = 1;
            } else if (i > 0) {
                mac = net.switch12.mac;
                sectionMAC = 2;
            } else if (i == 0) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的MAC地址!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }

            i = compareMacAddresses(mac, net.switch13.mac);
            if (i < 0) {

            } else if (i > 0) {
                mac = net.switch13.mac;
                sectionMAC = 3;
            } else if (i == 0) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的MAC地址!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }

            i = compareMacAddresses(mac, net.switch14.mac);
            if (i < 0) {

            } else if (i > 0) {
                mac = net.switch14.mac;
                sectionMAC = 4;
            } else if (i == 0) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的MAC地址!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }

            long min = Math.min(Math.min(Math.min(net.switch11.pri, net.switch12.pri), net.switch13.pri),
                    net.switch14.pri);
            int equalNumble[] = new int[] { 0, 0, 0, 0 };

            if (net.switch11.pri.equals(
                    net.switch12.pri)
                    && net.switch11.pri.equals(
                            net.switch13.pri)
                    && net.switch11.pri.equals(net.switch14.pri)) {
                root = sectionMAC;
            } else if (net.switch11.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[0] = 1;

            } else if (net.switch12.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[1] = 1;

            } else if (net.switch13.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[2] = 1;

            } else if (net.switch14.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[3] = 1;
            }

            int x = 0, y = 0;
            for (i = 0; i <= 1; i++) {
                if (equalNumble[i] == 1) {
                    x++;
                    y = i + 1;
                }
            }
            if (x == 1) {
                root = y;
            }
            if (root == 1) {
                IE.OI.panelAssume.root1.setSelected(true);
                return 1;
            } else if (root == 2) {
                IE.OI.panelAssume.root2.setSelected(true);
                return 1;
            } else if (root == 3) {
                IE.OI.panelAssume.root3.setSelected(true);
                return 1;
            } else if (root == 4) {
                IE.OI.panelAssume.root4.setSelected(true);
                return 1;
            }

        } else if (net.Example == 2) {

            if (!(net.switch21.pri > 0 && net.switch21.pri < 61440 && net.switch22.pri > 0
                    && net.switch22.pri < 61440 && net.switch23.pri > 0 && net.switch23.pri < 61440
                    && net.switch24.pri > 0
                    && net.switch24.pri < 61440)) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的优先级配置!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }
            String mac = "";
            int sectionMAC = 0;
            int i = compareMacAddresses(net.switch21.mac, net.switch22.mac);
            if (i < 0) {
                mac = net.switch21.mac;
                sectionMAC = 1;
            } else if (i > 0) {
                mac = net.switch22.mac;
                sectionMAC = 2;
            } else if (i == 0) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的MAC地址!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }

            i = compareMacAddresses(mac, net.switch23.mac);
            if (i < 0) {

            } else if (i > 0) {
                mac = net.switch23.mac;
                sectionMAC = 3;
            } else if (i == 0) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的MAC地址!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }

            i = compareMacAddresses(mac, net.switch24.mac);
            if (i < 0) {

            } else if (i > 0) {
                mac = net.switch24.mac;
                sectionMAC = 4;
            } else if (i == 0) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的MAC地址!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }

            long min = Math.min(Math.min(Math.min(net.switch21.pri, net.switch22.pri), net.switch23.pri),
                    net.switch24.pri);
            int equalNumble[] = new int[] { 0, 0, 0, 0 };

            if (net.switch21.pri.equals(
                    net.switch22.pri)
                    && net.switch21.pri.equals(
                            net.switch23.pri)
                    && net.switch21.pri.equals(net.switch24.pri)) {
                root = sectionMAC;
            } else if (net.switch21.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[0] = 1;

            } else if (net.switch22.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[1] = 1;

            } else if (net.switch23.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[2] = 1;

            } else if (net.switch24.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[3] = 1;
            }

            int x = 0, y = 0;
            for (i = 0; i <= 1; i++) {
                if (equalNumble[i] == 1) {
                    x++;
                    y = i + 1;
                }
            }
            if (x == 1) {
                root = y;
            }

            if (root == 1) {
                IE.OI.panelAssume.root1.setSelected(true);
                return 1;
            } else if (root == 2) {
                IE.OI.panelAssume.root2.setSelected(true);
                return 1;
            } else if (root == 3) {
                IE.OI.panelAssume.root3.setSelected(true);
                return 1;
            } else if (root == 4) {
                IE.OI.panelAssume.root4.setSelected(true);
                return 1;
            }

        } else if (net.Example == 3) {

            if (!(net.switch31.pri > 0 && net.switch31.pri < 61440 && net.switch32.pri > 0
                    && net.switch32.pri < 61440 && net.switch33.pri > 0 && net.switch33.pri < 61440
                    && net.switch34.pri > 0
                    && net.switch34.pri < 61440 && net.switch35.pri > 0 && net.switch35.pri < 61440)) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的优先级配置!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }
            String mac = "";
            int sectionMAC = 0;
            int i = compareMacAddresses(net.switch31.mac, net.switch32.mac);
            if (i < 0) {
                mac = net.switch31.mac;
                sectionMAC = 1;
            } else if (i > 0) {
                mac = net.switch32.mac;
                sectionMAC = 2;
            } else if (i == 0) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的MAC地址!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }

            i = compareMacAddresses(mac, net.switch33.mac);
            if (i < 0) {

            } else if (i > 0) {
                mac = net.switch33.mac;
                sectionMAC = 3;
            } else if (i == 0) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的MAC地址!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }

            i = compareMacAddresses(mac, net.switch34.mac);
            if (i < 0) {

            } else if (i > 0) {
                mac = net.switch34.mac;
                sectionMAC = 4;
            } else if (i == 0) {
                JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的MAC地址!</font></html>",
                        "警告", JOptionPane.INFORMATION_MESSAGE);
                return 0;
            }

            long min = Math.min(Math.min(Math.min(Math.min(net.switch31.pri,
                    net.switch32.pri), net.switch33.pri), net.switch34.pri),
                    net.switch35.pri);
            int equalNumble[] = new int[] { 0, 0, 0, 0, 0 };

            if (net.switch31.pri.equals(
                    net.switch32.pri)
                    && net.switch31.pri.equals(
                            net.switch33.pri)
                    && net.switch31.pri.equals(net.switch34.pri)) {
                root = sectionMAC;
            } else if (net.switch31.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[0] = 1;

            } else if (net.switch32.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[1] = 1;

            } else if (net.switch33.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[2] = 1;

            } else if (net.switch34.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[3] = 1;
            } else if (net.switch35.pri.equals(min)) {
                IE.OI.panelAssume.root1.setSelected(true);
                equalNumble[4] = 1;
            }

            int x = 0, y = 0;
            for (i = 0; i <= 1; i++) {
                if (equalNumble[i] == 1) {
                    x++;
                    y = i + 1;
                }
            }
            if (x == 1) {
                root = y;
            }

            if (root == 1) {
                IE.OI.panelAssume.root1.setSelected(true);
                return 1;
            } else if (root == 2) {
                IE.OI.panelAssume.root2.setSelected(true);
                return 1;
            } else if (root == 3) {
                IE.OI.panelAssume.root3.setSelected(true);
                return 1;
            } else if (root == 4) {
                IE.OI.panelAssume.root4.setSelected(true);
                return 1;
            } else if (root == 5) {
                IE.OI.panelAssume.root5.setSelected(true);
                return 1;
            }

        }
        return 0;
    }

    /**
     * 根端口选举
     * 比较cost
     */
    void Relection() {

        net.updateGraph();
        net.graph.showGraph();
        net.graph.dsj(root - 1);
        net.graph.showDsj();

        if (net.Example == 1) {
            if (root != 1) {

                int gen = net.graph.vv.pre_visited[0] + 1;
                if (gen == 2) {
                    IE.OI.panelAssume.Button1_1.setSelected(true);
                } else if (gen == 3) {
                    IE.OI.panelAssume.Button1_2.setSelected(true);
                }

            }
            if (root != 2) {

                int gen = net.graph.vv.pre_visited[1] + 1;
                if (gen == 1) {
                    IE.OI.panelAssume.Button2_1.setSelected(true);
                } else if (gen == 4) {
                    IE.OI.panelAssume.Button2_2.setSelected(true);
                }

            }
            if (root != 3) {

                int gen = net.graph.vv.pre_visited[2] + 1;
                if (gen == 1) {
                    IE.OI.panelAssume.Button3_1.setSelected(true);
                } else if (gen == 4) {
                    IE.OI.panelAssume.Button3_2.setSelected(true);
                }
            }
            if (root != 4) {

                int gen = net.graph.vv.pre_visited[3] + 1;
                if (gen == 2) {
                    IE.OI.panelAssume.Button4_1.setSelected(true);
                } else if (gen == 3) {
                    IE.OI.panelAssume.Button4_2.setSelected(true);
                }

            }
        } else if (net.Example == 2) {

            if (root != 1) {

                int gen = net.graph.vv.pre_visited[0] + 1;
                if (gen == 2) {
                    IE.OI.panelAssume.Button1_1.setSelected(true);
                } else if (gen == 3) {
                    IE.OI.panelAssume.Button1_2.setSelected(true);
                } else if (gen == 4) {
                    IE.OI.panelAssume.Button1_2.setSelected(true);
                }

            }
            if (root != 2) {

                int gen = net.graph.vv.pre_visited[1] + 1;
                if (gen == 1) {
                    IE.OI.panelAssume.Button2_1.setSelected(true);
                } else if (gen == 3) {
                    IE.OI.panelAssume.Button2_2.setSelected(true);
                } else if (gen == 4) {
                    IE.OI.panelAssume.Button2_3.setSelected(true);
                }

            }
            if (root != 3) {

                int gen = net.graph.vv.pre_visited[2] + 1;
                if (gen == 1) {
                    IE.OI.panelAssume.Button3_1.setSelected(true);
                } else if (gen == 2) {
                    IE.OI.panelAssume.Button3_2.setSelected(true);
                }
            }
            if (root != 4) {

                int gen = net.graph.vv.pre_visited[3] + 1;
                if (gen == 1) {
                    IE.OI.panelAssume.Button4_1.setSelected(true);
                } else if (gen == 2) {
                    IE.OI.panelAssume.Button4_2.setSelected(true);
                }

            }

        } else if (net.Example == 3) {

            if (root != 1) {

                int gen = net.graph.vv.pre_visited[0] + 1;
                if (gen == 3) {
                    IE.OI.panelAssume.Button1_1.setSelected(true);
                } else if (gen == 4) {
                    IE.OI.panelAssume.Button1_2.setSelected(true);
                }

            }
            if (root != 2) {

                int gen = net.graph.vv.pre_visited[1] + 1;
                if (gen == 4) {
                    IE.OI.panelAssume.Button2_1.setSelected(true);
                } 

            }
            if (root != 3) {

                int gen = net.graph.vv.pre_visited[2] + 1;
                if (gen == 1) {
                    IE.OI.panelAssume.Button3_1.setSelected(true);
                } else if (gen == 4) {
                    IE.OI.panelAssume.Button3_2.setSelected(true);
                } else if (gen == 5) {
                    IE.OI.panelAssume.Button3_3.setSelected(true);
                }
            }
            if (root != 4) {

                int gen = net.graph.vv.pre_visited[3] + 1;
                if (gen == 1) {
                    IE.OI.panelAssume.Button4_1.setSelected(true);
                } else if (gen == 2) {
                    IE.OI.panelAssume.Button4_2.setSelected(true);
                } else if (gen == 3) {
                    IE.OI.panelAssume.Button4_3.setSelected(true);
                } else if (gen == 5) {
                    IE.OI.panelAssume.Button4_4.setSelected(true);
                }
            }
            if (root != 5) {

                int gen = net.graph.vv.pre_visited[4] + 1;
                if (gen == 3) {
                    IE.OI.panelAssume.Button5_1.setSelected(true);
                } else if (gen == 4) {
                    IE.OI.panelAssume.Button5_2.setSelected(true);
                } 
            }

        }

    }

    /**
     * 指定端口选举
     */
    void Delection() {

    }

    /**
     * 比较mac地址
     */
    int compareMacAddresses(String mac1, String mac2) {
        byte[] bytes1 = convertMacStringToByteArray(mac1);
        byte[] bytes2 = convertMacStringToByteArray(mac2);

        for (int i = 0; i < bytes1.length; i++) {
            if (bytes1[i] != bytes2[i]) {
                return Byte.compare(bytes1[i], bytes2[i]);
            }
        }
        return 0;
    }

    byte[] convertMacStringToByteArray(String macString) {
        macString = macString.replaceAll("-", "").toUpperCase();

        if (macString.length() != 12) {
            JOptionPane.showMessageDialog(new Frame(), "<html><font face='黑体' size='5'>错误的MAC地址!</font></html>",
                    "警告", JOptionPane.INFORMATION_MESSAGE);
        }

        byte[] bytes = new byte[6];
        for (int i = 0; i < 6; i++) {
            try {
                bytes[i] = (byte) ((Character.digit(macString.charAt(i * 2), 16) << 4)
                        + Character.digit(macString.charAt(i * 2 + 1), 16));
            } catch (StringIndexOutOfBoundsException e) {
            }

        }

        return bytes;
    }

}
