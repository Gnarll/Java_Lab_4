package bsu.rfe.java.group9.Fedorovich.varB1;


import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

@SuppressWarnings("serial")
public class MainFrame extends JFrame
{

    // Начальные размеры окна приложения
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 1000;
    // Объект диалогового окна для выбора файлов
    private JFileChooser fileChooser = null;
    // Пункты меню
    private JCheckBoxMenuItem showAxisMenuItem;
    private JCheckBoxMenuItem showMarkersMenuItem;
    private JCheckBoxMenuItem showGridMenuItem;
    // Компонент-отображатель графика
    private GraphicsDisplay display = new GraphicsDisplay();
    // Флаг, указывающий на загруженность данных графика
    private boolean fileLoaded = false;

    public MainFrame()
    {
    }

    public static void main(String[] args)
    {
        // Создать и показать экземпляр главного окна приложения
        MainFrame frame = new MainFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Класс-слушатель событий, связанных с отображением меню
    private class GraphicsMenuListener implements MenuListener
    {
        // Обработчик, вызываемый перед показом меню
        public void menuSelected(MenuEvent e)
        {
            // Доступность или недоступность элементов меню "График" определяется загруженностью данных
            showAxisMenuItem.setEnabled(fileLoaded);
            showMarkersMenuItem.setEnabled(fileLoaded);
            showGridMenuItem.setEnabled(fileLoaded);
        }

        // Обработчик, вызываемый после того, как меню исчезло с экрана
        public void menuDeselected(MenuEvent e)
        {
        }
// Обработчик, вызываемый в случае отмены выбора пункта меню(очень редкая ситуация)

        public void menuCanceled(MenuEvent e)
        {
        }
    }
}
