import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyMemoryButton extends Button implements ActionListener {
    MyCalculator cl;

    public MyMemoryButton(int x, int y, int width, int height, String cap, MyCalculator clc) {
        super(cap);
        setBounds(x, y, width, height);
        this.cl = clc;
        this.cl.add(this);
        addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ev) {
        char memop = ((MyMemoryButton) ev.getSource()).getLabel().charAt(1);

        cl.setClear = true;
        double temp = Double.parseDouble(cl.displayLabel.getText());

        switch (memop) {
            case 'C':
                cl.memLabel.setText(" ");
                cl.memValue = 0.0;
                break;
            case 'R':
                cl.displayLabel.setText(MyCalculator.getFormattedText(cl.memValue));
                break;
            case 'S':
                cl.memValue = 0.0;
                break;
            case '+':
                cl.memValue += Double.parseDouble(cl.displayLabel.getText());
                if(cl.displayLabel.getText().equals("0")){
                    cl.memLabel.setText(" ");
                } else{
                    cl.memLabel.setText("M");
                }
                break;

            default:
                break;
        }
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }

}
