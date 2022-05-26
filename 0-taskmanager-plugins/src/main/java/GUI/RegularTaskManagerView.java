package GUI;

import Category.Category;
import Person.Person;
import Task.Task;
import Task.Status;
import application.TaskManager;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import repositiories.CategoryRepositoryImplementation;
import repositiories.PersonRepositoryImplementation;
import repositiories.TaskRepositoryImplementation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

public class RegularTaskManagerView extends JFrame {
    private JPanel contentPane;
    private JButton addTaskButton;
    private JButton addPersonButton;
    private JButton categoriesButton;
    private JList<Task> taskJList;
    private JComboBox filterTopicBox;
    private JComboBox filterValueBox;
    private JButton changeViewButton;
    private JPanel taskListJPanel;
    private JScrollPane tasksJScrollPane;
    private JList list1;
    private JList list2;
    private JList list3;
    private JList list4;
    private JPanel eisenhowerJPanel;
    protected TaskManager taskManager;
    private boolean eisenhowerModeOn;

    public RegularTaskManagerView() {
        taskListJPanel.remove(eisenhowerJPanel);
        setContentPane(contentPane);
        setTitle("Task Manager");
        setLocationRelativeTo(null);
        taskJList.setCellRenderer(new ColoringCellRenderer());
        setSize(800, 500);
        setVisible(true);
        this.taskManager = new TaskManager(new TaskRepositoryImplementation(), new CategoryRepositoryImplementation(), new PersonRepositoryImplementation());
        for (FilterTopic topic : FilterTopic.values()) {
            filterTopicBox.addItem(topic);
        }
        setListener();
    }

    public static void main(String[] args) {
        RegularTaskManagerView regularTaskManagerView = new RegularTaskManagerView();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        contentPane = new JPanel();
        contentPane.setLayout(new BorderLayout(0, 0));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new BorderLayout(0, 0));
        contentPane.add(panel1, BorderLayout.SOUTH);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(1, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, BorderLayout.NORTH);
        addTaskButton = new JButton();
        addTaskButton.setText("Add Task");
        panel2.add(addTaskButton, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final Spacer spacer1 = new Spacer();
        panel2.add(spacer1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(6, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(panel3, BorderLayout.WEST);
        categoriesButton = new JButton();
        categoriesButton.setText("Categories");
        panel3.add(categoriesButton, new GridConstraints(4, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        addPersonButton = new JButton();
        addPersonButton.setText("Persons");
        panel3.add(addPersonButton, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        filterTopicBox = new JComboBox();
        panel3.add(filterTopicBox, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        filterValueBox = new JComboBox();
        panel3.add(filterValueBox, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Filter By");
        panel3.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        changeViewButton = new JButton();
        changeViewButton.setText("Change View");
        panel3.add(changeViewButton, new GridConstraints(5, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        taskListJPanel = new JPanel();
        taskListJPanel.setLayout(new GridLayoutManager(2, 1, new Insets(0, 0, 0, 0), -1, -1));
        contentPane.add(taskListJPanel, BorderLayout.CENTER);
        tasksJScrollPane = new JScrollPane();
        taskListJPanel.add(tasksJScrollPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        taskJList = new JList();
        tasksJScrollPane.setViewportView(taskJList);
        eisenhowerJPanel = new JPanel();
        eisenhowerJPanel.setLayout(new GridLayoutManager(4, 2, new Insets(0, 0, 0, 0), -1, -1));
        taskListJPanel.add(eisenhowerJPanel, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JScrollPane scrollPane1 = new JScrollPane();
        eisenhowerJPanel.add(scrollPane1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list1 = new JList();
        scrollPane1.setViewportView(list1);
        final JScrollPane scrollPane2 = new JScrollPane();
        eisenhowerJPanel.add(scrollPane2, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list2 = new JList();
        scrollPane2.setViewportView(list2);
        final JScrollPane scrollPane3 = new JScrollPane();
        eisenhowerJPanel.add(scrollPane3, new GridConstraints(3, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list3 = new JList();
        scrollPane3.setViewportView(list3);
        final JScrollPane scrollPane4 = new JScrollPane();
        eisenhowerJPanel.add(scrollPane4, new GridConstraints(3, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        list4 = new JList();
        scrollPane4.setViewportView(list4);
        final JLabel label2 = new JLabel();
        label2.setText("Important and Urgent");
        eisenhowerJPanel.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        label3.setText("Important and not Urgent");
        eisenhowerJPanel.add(label3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label4 = new JLabel();
        label4.setText("Unimportant and urgent");
        eisenhowerJPanel.add(label4, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label5 = new JLabel();
        label5.setText("Unimportant and not Urgent");
        eisenhowerJPanel.add(label5, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return contentPane;
    }

    public void setListener() {

        filterTopicBox.addActionListener(e -> {
            switch ((FilterTopic) filterTopicBox.getSelectedItem()) {
                case NONE:
                    filterValueBox.removeAllItems();
                    return;
                case CATEGORY:
                    filterValueBox.removeAllItems();
                    for (Category category : taskManager.getCategoryService().getAllCategories()) {
                        filterValueBox.addItem(category);
                    }
                    return;
                case PERSON:
                    filterValueBox.removeAllItems();
                    for (Person person : taskManager.getPersonService().getAllPersons()) {
                        filterValueBox.addItem(person);
                    }
                    return;
                case STATUS:
                    for (Status status : Status.values()) {
                        filterValueBox.addItem(status);
                    }
                    return;
                default:
                    filterValueBox.removeAllItems();
            }
        });

        filterValueBox.addActionListener(e -> {
            updateTaskList();
        });
        addTaskButton.addActionListener(e -> {
            TaskView taskView = new TaskView(this);
        });

        addPersonButton.addActionListener(e -> {
            PersonsView personsView = new PersonsView(this);
        });
        categoriesButton.addActionListener(e -> {
            CategoriesView categoriesView = new CategoriesView(this);
        });
        RegularTaskManagerView thisView = this;
        MouseListener mouseListener = new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    Task selectedTask = taskJList.getSelectedValue();
                    TaskView taskView = new TaskView(thisView, selectedTask);
                }
            }
        };
        taskJList.addMouseListener(mouseListener);

        changeViewButton.addActionListener(e -> {
            changeLayout();
        });
    }

    private void changeLayout() {
        if (!eisenhowerModeOn) {
            eisenhowerModeOn = true;
            filterValueBox.setEnabled(false);
            filterTopicBox.setEnabled(false);
            taskListJPanel.remove(tasksJScrollPane);
            taskListJPanel.setLayout(new GridLayoutManager(1, 1));
            taskListJPanel.add(eisenhowerJPanel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
            updateTaskList();
            repaint();
            revalidate();
        } else {
            filterValueBox.setEnabled(true);
            filterTopicBox.setEnabled(true);
            eisenhowerModeOn = false;
            taskListJPanel.remove(eisenhowerJPanel);
            taskListJPanel.setLayout(new GridLayoutManager(1, 1));
            taskListJPanel.add(tasksJScrollPane, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
            updateTaskList();
            repaint();
            revalidate();

        }
    }

    protected void updateTaskList() {
        if (eisenhowerModeOn) {
            DefaultListModel<Task> model1 = new DefaultListModel<Task>();
            for (Task task : taskManager.getTaskService().getImportantAndUrgentTasks()) {
                model1.addElement(task);
            }
            JList<Task> importantAndUrgentTasks = new JList<Task>();
            list1.setCellRenderer(new ColoringCellRenderer());
            list1.setModel(model1);

            DefaultListModel<Task> model2 = new DefaultListModel<Task>();
            for (Task task : taskManager.getTaskService().getImportantAndNotUrgentTasks()) {
                model2.addElement(task);
            }
            JList<Task> importantAndNotUrgentTasks = new JList<Task>();
            list2.setCellRenderer(new ColoringCellRenderer());
            list2.setModel(model2);

            DefaultListModel<Task> model3 = new DefaultListModel<Task>();
            for (Task task : taskManager.getTaskService().getUnimportantAndUrgentTasks()) {
                model3.addElement(task);
            }
            JList<Task> unimportantAndUrgentTasks = new JList<Task>();
            list3.setCellRenderer(new ColoringCellRenderer());
            list3.setModel(model3);

            DefaultListModel<Task> model4 = new DefaultListModel<Task>();
            for (Task task : taskManager.getTaskService().getUnimportantAndNotUrgentTasks()) {
                model4.addElement(task);
            }
            JList<Task> unimportantAndNotUrgentTasks = new JList<Task>();
            list4.setCellRenderer(new ColoringCellRenderer());
            list4.setModel(model4);




        } else {
            DefaultListModel<Task> model = new DefaultListModel<Task>();
            switch ((FilterTopic) filterTopicBox.getSelectedItem()) {
                case CATEGORY:
                    for (Task task : taskManager.getTaskService().getTasksByCategory((Category) filterValueBox.getSelectedItem())) {
                        model.addElement(task);
                    }
                    taskJList.setModel(model);
                    return;
                case PERSON:
                    for (Task task : taskManager.getTaskService().getTasksByPerson((Person) filterValueBox.getSelectedItem())) {
                        model.addElement(task);
                    }
                    return;
                case STATUS:
                    Status status = (Status) filterValueBox.getSelectedItem();
                    List<Task> tasks = taskManager.getTaskService().getTasksByStatus(status);
                    for (Task task : taskManager.getTaskService().getTasksByStatus((Status) filterValueBox.getSelectedItem())) {
                        model.addElement(task);
                    }
                    taskJList.setModel(model);
                    return;
                default:
                    for (Task task : taskManager.getTaskService().getAllTasks()) {
                        model.addElement(task);
                    }
                    taskJList.setModel(model);
                    return;
            }
        }
    }

    private static class ColoringCellRenderer extends DefaultListCellRenderer {
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            c.setBackground(((Task) value).getCategory().getColor());
            return c;
        }
    }


}
