import java.awt.*;
import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.*;
class E {
   public static void main(String args[]) {
   ComputerFrame fr = new ComputerFrame();
   fr.setTitle("计算");// 窗口标题设为“计算”
   }
}
class ComputerFrame extends JFrame implements ActionListener{//实现接口ActionListener
JTextFieldtext1,text2,text3;
JButtonbuttonAdd,buttonSub,buttonMul,buttonDiv;
JLabellabel;
publicComputerFrame(){
setLayout(newFlowLayout());//P253设置FlowLayout流水布局
text1=newJTextField(10);
text2=newJTextField(10);
text3=newJTextField(10);
label=newJLabel("",JLabel.CENTER);
label.setBackground(Color.green);
add(text1);
add(label);
add(text2);
add(text3);
buttonAdd=newJButton("加");
buttonSub=newJButton("减");
buttonMul=newJButton("乘");
buttonDiv=newJButton("除");
add(buttonAdd);
add(buttonSub);
add(buttonMul);
add(buttonDiv);
buttonAdd.addActionListener(this);//当前窗口作为buttonAdd的监视器
buttonSub.addActionListener(this);
buttonMul.addActionListener(this);
buttonDiv.addActionListener(this);
setSize(300,320);
setVisible(true);
validate();
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
}
publicvoidactionPerformed(ActionEvente){
//实现接口ActionListener中的方法actionPerformed
doublen;
if(e.getSource()==buttonAdd){
doublen1,n2;
try{
n1=Double.parseDouble(text1.getText());
n2=Double.parseDouble(text2.getText());
n=n1+n2;
text3.setText(String.valueOf(n));
label.setText("+");
}catch(NumberFormatExceptionee){
text3.setText("请输入数字字符");
}
}elseif(e.getSource()==buttonSub){
doublen1,n2;
try{
n1=Double.parseDouble(text1.getText());
n2=Double.parseDouble(text2.getText());
n=n1-n2;
text3.setText(String.valueOf(n));
label.setText("-");
}catch(NumberFormatExceptionee){
text3.setText("请输入数字字符");
}
}elseif(e.getSource()==buttonMul){
doublen1,n2;
try{
n1=Double.parseDouble(text1.getText());
n2=Double.parseDouble(text2.getText());
n=n1*n2;
text3.setText(String.valueOf(n));
label.setText("*");
}catch(NumberFormatExceptionee){
text3.setText("请输入数字字符");
}
}elseif(e.getSource()==buttonDiv){
doublen1,n2;
try{
n1=Double.parseDouble(text1.getText());
n2=Double.parseDouble(text2.getText());
n=n1/n2;
text3.setText(String.valueOf(n));
label.setText("/");
}catch(NumberFormatExceptionee){
text3.setText("请输入数字字符");
}
}
validate();//P246刷新操作，验证容器中的组件能正确显示出来。
}
}