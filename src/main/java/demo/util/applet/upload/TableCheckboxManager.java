package demo.util.applet.upload;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TableCheckboxManager {

    public static final int SELECT_PART = 0;

    public static final int SELECT_ALL = 1;

    public static final int SELECT_NONE = 2;

    //    private List<JCheckBox> tableCheck = new ArrayList<JCheckBox>(); //  @jve:decl-index=0:

    private byte[] tableCheck = new byte[0]; //  @jve:decl-index=0:

    private IndexJCheckBox[] templetBox = new IndexJCheckBox[] {
            new IndexJCheckBox((String) null, false),
            new IndexJCheckBox((String) null, true) };

    private JTable table;

    private JCheckBox headerCheckBox;

    private int checkStata = -1;

    private Map<Integer, Object> selectedIndexMap = new HashMap<Integer, Object>();

    private int tableCheckedCount = 0;

    private boolean fireChanged = true;

    //    private IndexJCheckBox addCheckBox = null;

    private int headerCheckBoxColumn = 0;

    private int checkBoxColumn = 0;

    private static final int DFAULT_MAX_WIDTH = 23;

    private static final int DFAULT_MIN_WIDTH = 23;

    private static final int DFAULT_PREFERRED_WIDTH = 23;

    private int maxWidth = DFAULT_MAX_WIDTH;

    private int minWidth = DFAULT_MIN_WIDTH;

    private int preferredWidth = DFAULT_PREFERRED_WIDTH;

    private IndexJCheckBox editorCheckBox = new IndexJCheckBox();

    private MouseListener nowMouseListen = null;

    //    private ChangeListener checkChange = new ChangeListener() {
    //        public void stateChanged(ChangeEvent e) {
    //            checkedChanged((JCheckBox) e.getSource());
    //        }
    //    };

    private ActionListener actionChange = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            clickCheckBox(table.getEditingRow());
            checkedChanged2(table.getEditingRow());
        }
    };

    public TableCheckboxManager(JTable table, List<JCheckBox> checkBoxs) {
        this.table = table;
        addTableMouseListener();
        setColumnAttributes();
        saveCheckBoxListStata(checkBoxs);
    }

    public void close() {
        clear();
        table = null;
    }

    private void clear() {
        tableCheck = new byte[0]; //  @jve:decl-index=0:

        table = null;

        headerCheckBox = null;

        checkStata = -1;

        selectedIndexMap = new HashMap<Integer, Object>();

        tableCheckedCount = 0;

        fireChanged = true;

        //        addCheckBox = null;

        headerCheckBoxColumn = 0;

        checkBoxColumn = 0;

        removeSet();
    }

    public void setCheckBoxColumn(int col) {
        checkBoxColumn = col;
        if (table != null) {
            setColumnAttributes();
        }
    }

    public void setSelected(int[] indexs) {
        for (int i = 0; i < indexs.length; i++) {
            tableCheck[indexs[i]] = 1;
            tableCheckedCount++;
        }
        updateStata();
        table.revalidate();
        table.repaint();
    }

    private void setColumnAttributes() {
        TableColumn tc = table.getColumnModel().getColumn(checkBoxColumn);
        tc.setPreferredWidth(preferredWidth);
        tc.setMaxWidth(maxWidth);
        tc.setMinWidth(minWidth);
        tc.setCellRenderer(getCheckBoxsCellRenderer());
        tc.setCellEditor(getCheckBoxsCellEditor(true));
    }

    private void addTableMouseListener() {
        nowMouseListen = new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                if (e.getButton() != java.awt.event.MouseEvent.BUTTON1)
                    return;
                if (e.getClickCount() == 1) {
                    int selectRow = TableCheckboxManager.this.table
                            .getSelectedRow();
                    if (selectRow > -1) {
                        int col = TableCheckboxManager.this.table
                                .columnAtPoint(e.getPoint());
                        if (col != -1 && col == checkBoxColumn) {
                            clickCheckBox(selectRow);
                            checkedChanged(selectRow);
                            table.revalidate();
                            table.repaint();
                        }
                    }
                }
            }

            /**
             * Invoked when the mouse exits a component.
             */
            public void mouseExited(MouseEvent e) {
            }
        };
        table.addMouseListener(nowMouseListen);
    }

    public TableCheckboxManager(List<JCheckBox> checkBoxs) {
        saveCheckBoxListStata(checkBoxs);
    }

    public TableCheckboxManager() {
    }

    private void saveCheckBoxListStata(List<JCheckBox> checkBoxs) {
        tableCheck = new byte[checkBoxs.size()];
        for (int i = 0; i < checkBoxs.size(); i++) {
            tableCheck[i] = (byte) (checkBoxs.get(i).isSelected() ? 1 : 0);
        }
    }

    public void setTable(JTable table) {
        clear();
        boolean addMouseLisen = false;
        if (this.table != table) {
            addMouseLisen = true;
        }
        if (addMouseLisen) {
            this.table = table;
            addTableMouseListener();
            setColumnAttributes();
        }
    }

    public void removeSet() {
        if (table != null) {
            table.removeMouseListener(nowMouseListen);
            TableColumn tc = table.getColumnModel().getColumn(checkBoxColumn);
            tc.setCellRenderer(null);
            tc.setCellEditor(null);
        }
    }

    public TableCheckboxManager(JTable table) {
        this.table = table;
        addTableMouseListener();
        setColumnAttributes();
    }

    public JCheckBox getCheckBox(int i) {
        return templetBox[tableCheck[i]];
    }

    public boolean isSelected(int i) {
        return tableCheck[i] == 0 ? false : true;
    }

    public int size() {
        return tableCheck.length;
    }

    public void clearCheckBoxList() {
        createCheckBoxList();
    }

    public void createCheckBoxList() {
        tableCheck = new byte[0];
        selectedIndexMap = new HashMap<Integer, Object>();
        tableCheckedCount = 0;
        checkStata = -1;
        selectLogicCheckBoxChecked(true);
    }

    public void resetCheckBox(int size) {
        createCheckBoxList();
        addCheckBoxs(size);
        checkStata--;
        selectLogicCheckBoxChecked(true);
    }

    //    public List<JCheckBox> getCheckBoxList() {
    //        return tableCheck;
    //    }

    //    public void setCheckBoxList(List<JCheckBox> checkBoxList) {
    //        tableCheck = checkBoxList;
    //    }

    public JTable getTable() {
        return this.table;
    }

    {
        initCheckBox();
    }

    public void initCheckBox() {
        for (int i = 0; i < templetBox.length; i++) {
            //            templetBox[i].addChangeListener(checkChange);
            templetBox[i].setVisible(true);
        }
        editorCheckBox.addActionListener(actionChange);
        editorCheckBox.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                if (table.getEditingRow() > 0
                        && table.getEditingRow() < tableCheck.length) {
                    editorCheckBox
                            .setSelected(tableCheck[table.getEditingRow()] == 0 ? false
                                    : true);
                }
            }
        });
    }

    public void addCheckBoxs(int size) {
        tableCheck = new byte[size];
        //        addTableMouseListener();
        //        setColumnAttributes();
    }

    public void setHeaderShowCheckbox(int col) {
        headerCheckBoxColumn = col;
        final JTableHeader jh = table.getTableHeader();
        TableColumnModel headerColumnMode = jh.getColumnModel();

        headerColumnMode.getColumn(0).setHeaderRenderer(
                new TableHeaderRenderer(getHeaderCheckBox()));
        jh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent e) {
                int column;
                if ((column = jh.columnAtPoint(e.getPoint())) != -1) {
                    TableColumn tc = table.getColumnModel().getColumn(
                            checkBoxColumn);
                    tc.getCellEditor().cancelCellEditing();
                    if (column == headerCheckBoxColumn) {
                        selectLogicCheckBoxChecked(true);
                        jh.repaint();
                    }
                }
            }
        });
    }

    private void selectLogicCheckBoxChecked(boolean seleteSaveTable) {
        checkStata++;
        if (checkStata == 3) {
            checkStata = 0;
        }
        switch (checkStata) {
        case SELECT_PART:
            getHeaderCheckBox().setSelected(true);
            getHeaderCheckBox().setEnabled(false);
            if (seleteSaveTable) {
                seletedCheckBoxCheck();
            }
            break;
        case SELECT_ALL:
            getHeaderCheckBox().setSelected(true);
            getHeaderCheckBox().setEnabled(true);
            if (seleteSaveTable) {
                selectAllTable(true);
            }
            break;
        case SELECT_NONE:
            getHeaderCheckBox().setSelected(false);
            getHeaderCheckBox().setEnabled(true);
            if (seleteSaveTable) {
                selectAllTable(false);
            }
            break;
        }
        table.getTableHeader().repaint();
    }

    private void checkedChanged(int index) {
        if (fireChanged && !table.isEditing()) {
            changeStata(index);
        }
    }

    private void checkedChanged2(int index) {
        if (table.isEditing()) {
            changeStata(index);
        }
    }

    private void changeStata(int index) {

        if (checkStata == SELECT_NONE) {
            selectedIndexMap = new HashMap<Integer, Object>();
        }

        if (checkStata == SELECT_ALL) {
            selectedIndexMap = new HashMap<Integer, Object>();
            for (int i = 0; i < tableCheck.length; i++) {
                selectedIndexMap.put(i, null);
            }
        }

        if (tableCheck[index] == 1) {
            tableCheckedCount++;
            selectedIndexMap.put(index, null);
        } else {
            tableCheckedCount--;
            selectedIndexMap.remove(index);
        }

        updateStata();
    }

    private void updateStata() {
        int changedStata = 0;
        if (tableCheckedCount != 0) {
            if (tableCheckedCount == tableCheck.length) {
                changedStata = SELECT_ALL;
            } else {
                changedStata = SELECT_PART;
            }
        } else {
            changedStata = SELECT_NONE;
        }

        if (changedStata != checkStata) {
            changedStata--;
            checkStata = changedStata;
            selectLogicCheckBoxChecked(false);
            table.getTableHeader().repaint();
        }
    }

    private void selectAllTable(boolean check) {
        fireChanged = false;
        byte nowCheckStata = (byte) (check ? 1 : 0);
        for (int i = 0; i < tableCheck.length; i++) {
            tableCheck[i] = nowCheckStata;
        }
        if (check) {
            tableCheckedCount = tableCheck.length;
        } else {
            tableCheckedCount = 0;
        }
        table.revalidate();
        table.repaint();
        fireChanged = true;
    }

    private JCheckBox getHeaderCheckBox() {
        if (headerCheckBox == null) {
            headerCheckBox = new JCheckBox();
            headerCheckBox.setBorderPainted(true);
        }
        return headerCheckBox;
    }

    private void clickCheckBox(int i) {
        if (tableCheck != null) {
            tableCheck[i] = (byte) (tableCheck[i] == 0 ? 1 : 0);
        }
    }

    protected class TableHeaderRenderer implements TableCellRenderer {
        private JCheckBox renderCheckBoxs;

        public TableHeaderRenderer(JCheckBox tableCheck) {
            renderCheckBoxs = tableCheck;
        }

        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            return renderCheckBoxs;
        }
    }

    private void seletedCheckBoxCheck() {
        fireChanged = false;
        tableCheckedCount = 0;

        Set<Integer> keys = selectedIndexMap.keySet();
        int checkIndex = 0;
        for (Iterator<Integer> keyItr = keys.iterator(); keyItr.hasNext();) {
            checkIndex = keyItr.next();
            if (tableCheck.length > checkIndex) {
                tableCheck[checkIndex] = 1;
                tableCheckedCount++;
            }
        }

        if (tableCheckedCount == 0) {
            selectLogicCheckBoxChecked(true);
        } else if (tableCheck.length > 0
                && tableCheckedCount == tableCheck.length) {
            selectLogicCheckBoxChecked(false);
        }
        table.revalidate();
        table.repaint();
        fireChanged = true;
    }

    public void changeCheckBoxStata(int... stata) {
        for (int i = 0; i < stata.length; i++) {
            checkStata = stata[i] - 1;
            selectLogicCheckBoxChecked(true);
            if (checkStata == stata[i]) {
                break;
            }
        }
    }

    public void clearAndChangeCheckBoxStata(int... stata) {
        clearSelect();
        changeCheckBoxStata(stata);
    }

    private void clearSelect() {
        selectAllTable(false);
    }

    public void setSelectedCheckIndexs(List<Integer> selectedInx) {
        selectedIndexMap = new HashMap<Integer, Object>();
        for (int i = 0; i < selectedInx.size(); i++) {
            selectedIndexMap.put(selectedInx.get(i), null);
        }
    }

    public TableCellEditor getCheckBoxsCellEditor(boolean addListener) {
        TableCellEditor tce = new CheckBoxsCellEditor();
        if (addListener)
            tce.addCellEditorListener(new CheckBoxCellEditorListener());
        return tce;
    }

    public TableCellRenderer getCheckBoxsCellRenderer() {
        return new CheckBoxsRenderer();
    }

    class CheckBoxsCellEditor extends DefaultCellEditor {

        /**
         * 
         */
        private static final long serialVersionUID = -1875319868682535006L;

        public CheckBoxsCellEditor() {
            super(new JTextField());
        }

        public Component getTableCellEditorComponent(JTable table,
                Object value, boolean isSelected, int row, int column) {
            return editorCheckBox;
        }
    }

    protected class CheckBoxsRenderer implements TableCellRenderer {

        public CheckBoxsRenderer() {
        }

        public Component getTableCellRendererComponent(JTable table,
                Object value, boolean isSelected, boolean hasFocus, int row,
                int column) {
            if (row < tableCheck.length) {
                return (Component) templetBox[tableCheck[row]];
            }
            return null;
        }
    }

    private class IndexJCheckBox extends JCheckBox {
        public IndexJCheckBox(String text, boolean selected) {
            super(text, selected);
        }

        public IndexJCheckBox() {
            super();
        }

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        private int index = 0;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    public Set<Integer> getSelectedIndexSet() {
        switch (checkStata) {
        case SELECT_PART:
            return selectedIndexMap.keySet();
        case SELECT_ALL:
            HashSet<Integer> allItem = new HashSet<Integer>();
            for (int i = 0; i < tableCheck.length; i++) {
                allItem.add(i);
            }
            return allItem;
        case SELECT_NONE:
            return new HashSet<Integer>();
        }
        return new HashSet<Integer>();
    }

    class CheckBoxCellEditorListener implements CellEditorListener {
        int row;

        int col;

        public void editingStopped(ChangeEvent e) {
            table.revalidate();
            table.repaint();
            //            editorCheckBox
            //                    .setSelected(tableCheck[table.getEditingRow()] == 0 ? false
            //                            : true);
            //            editorCheckBox.setIndex(table.getEditingRow());
        }

        public void editingCanceled(ChangeEvent e) {
            table.revalidate();
            table.repaint();
        }

    }

    public void removeAllSelectedIndex() {
        selectedIndexMap = new HashMap<Integer, Object>();
        tableCheckedCount = 0;
        updateStata();
    }

    public Integer[] getSortedSelectedIndexs() {
        Set<Integer> selectIndex = getSelectedIndexSet();
        Integer[] indexs = new Integer[selectIndex.size()];
        indexs = selectIndex.toArray(indexs);
        Arrays.sort(indexs);
        return indexs;
    }

    public void removeAllSelectedIndexAndCheckBox() {
        Integer[] indexs = getSortedSelectedIndexs();
        tableCheck = new byte[tableCheck.length - indexs.length];
    }

    public void removeAllSelectedIndexAndCheckBox(Integer[] indexs) {
        tableCheck = new byte[tableCheck.length - indexs.length];
        for (int i = indexs.length - 1; i >= 0; i--) {
            selectedIndexMap.remove(indexs[i]);
        }
        tableCheckedCount = selectedIndexMap.size();
        updateStata();
    }

    /**
     * maxWidth��Ԃ��܂��B
     * @return maxWidth
     */
    public int getMaxWidth() {
        return maxWidth;
    }

    /**
     * maxWidth��ݒ肵�܂��B
     * @param maxWidth  maxWidth�֐ݒ�
     */
    public void setMaxWidth(int maxWidth) {
        this.maxWidth = maxWidth;
    }

    /**
     * minWidth��Ԃ��܂��B
     * @return minWidth
     */
    public int getMinWidth() {
        return minWidth;
    }

    /**
     * minWidth��ݒ肵�܂��B
     * @param minWidth  minWidth�֐ݒ�
     */
    public void setMinWidth(int minWidth) {
        this.minWidth = minWidth;
    }

    /**
     * preferredWidth��Ԃ��܂��B
     * @return preferredWidth
     */
    public int getPreferredWidth() {
        return preferredWidth;
    }

    /**
     * preferredWidth��ݒ肵�܂��B
     * @param preferredWidth  preferredWidth�֐ݒ�
     */
    public void setPreferredWidth(int preferredWidth) {
        this.preferredWidth = preferredWidth;
    }
}
