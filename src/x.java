import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class x {

    JRadioButton r1 = new JRadioButton("选项1");  
    r1.addActionListener(new ActionListener() {  
    @Override  
    public void actionPerformed(ActionEvent e) {  
        // 处理单选按钮被选中或取消选中的事件  
        if (r1.isSelected()) {  
            // 执行相应操作  
        }  
    }  
});

    r1.addActionListener(e->{if(r1.isSelected()){
// 执行相应操作
}});



    JRadioButton jrb1 = new JRadioButton("选项1");  
jrb1.addItemListener(new ItemListener() {  
    @Override  
    public void itemStateChanged(ItemEvent e) {  
        if (e.getStateChange() == ItemEvent.SELECTED) {  
            // 处理单选按钮被选中的事件  
        } else if (e.getStateChange() == ItemEvent.DESELECTED) {  
            // 处理单选按钮被取消选中的事件  
        }  
    }  
});
    
}

  
class JTextFieldExample {  
  
    public static void main(String[] args) {  
        // 创建一个 JTextField  
        JTextField textField = new JTextField(20);  
  
        // 创建一个 DocumentListener 的匿名内部类实例  
        textField.getDocument().addDocumentListener(new DocumentListener() {  
            @Override  
            public void insertUpdate(DocumentEvent e) {  
                // 当文本被插入时执行的代码  
                System.out.println("文本被插入: " + textField.getText());  
            }  
  
            @Override  
            public void removeUpdate(DocumentEvent e) {  
                // 当文本被删除时执行的代码  
                System.out.println("文本被删除: " + textField.getText());  
            }  
  
            @Override  
            public void changedUpdate(DocumentEvent e) {  
                // 当文本内容以其他方式更改时执行的代码  
                // （注意：对于 JTextField，changedUpdate 通常不会被调用）  
                System.out.println("文本内容已更改: " + textField.getText());  
            }  
        });  
  
        // 创建一个 JFrame 来显示 JTextField  
        JFrame frame = new JFrame("JTextField 示例");  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.add(textField);  
        frame.pack();  
        frame.setVisible(true);  
    }  
}
