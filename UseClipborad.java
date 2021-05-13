
public UseClipborad() {

	JTextArea textArea = new JTextArea();
	splitPane.setLeftComponent(textArea);
		
	JMenu mnNewMenu_1 = new JMenu("Edit");
	menuBar.add(mnNewMenu_1);
		
	JMenuItem mntmNewMenuItem_4 = new JMenuItem("Copy");
	mntmNewMenuItem_4.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			StringSelection data = new StringSelection(textArea.getSelectedText());
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(data, data);
			}
	});
	mnNewMenu_1.add(mntmNewMenuItem_4);
		
	JMenuItem mntmNewMenuItem_5 = new JMenuItem("Paste");
	mntmNewMenuItem_5.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable contents = clipboard.getContents(clipboard);
		         String pasteString = null;
			try {
				pasteString = (String)(contents.getTransferData(DataFlavor.stringFlavor));
			} catch (UnsupportedFlavorException | IOException e1) {
				e1.printStackTrace();
			}
		        textArea.insert(pasteString, textArea.getCaretPosition());
		}
	});
	mnNewMenu_1.add(mntmNewMenuItem_5);
		
	JMenuItem mntmNewMenuItem_6 = new JMenuItem("Cut");
	mntmNewMenuItem_6.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			StringSelection data = new StringSelection(textArea.getSelectedText());
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			clipboard.setContents(data, data);
			int start = textArea.getSelectionStart();
			int end = textArea.getSelectionEnd();
			textArea.replaceRange("", start, end);

			}
		});

