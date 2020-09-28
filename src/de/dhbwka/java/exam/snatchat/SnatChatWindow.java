package de.dhbwka.java.exam.snatchat;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class SnatChatWindow extends JFrame implements SnatChatFrontend {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Account account;
	private SnatChatRoom room;
	private JTextField inputField;
	private JButton sendButton;
	private ChatMessagesComponent chats;
	private List<JLabel> messages;
	private List<Integer> seconds;
	private Timer timer = new Timer();
	private JFrame fenster;

	public SnatChatWindow(SnatChatRoom room, Account account) {
		this.room = room;
		this.account = account;

		fenster = this;

		messages = new ArrayList<JLabel>();
		seconds = new ArrayList<Integer>();

		initilizeComponents();
		
		timer.schedule(new TimerTask() {
            @Override
            public void run() {
				for(int i = messages.size() - 1; i >= 0; i--){
					Integer sec = seconds.get(i);
					sec--;
					seconds.set(i, sec);

					if(sec == 0){
						chats.remove(messages.get(i));
						messages.remove(messages.get(i));
						seconds.remove(seconds.get(i));
					}
					else{
						if(messages.get(i).getText().endsWith("]"))
							messages.get(i).setText(messages.get(i).getText().substring(0, messages.get(i).getText().lastIndexOf("[")) + "[" + seconds.get(i) + "]");
						else
							messages.get(i).setText(messages.get(i).getText() + " [" + seconds.get(i) + "]");
					}
				}
				fenster.repaint();
            }
		}, 0, 1000);	
	}

	private void initilizeComponents() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle(account.getName() + " (" + room.getRoomName() + ")");

		JLabel name = new JLabel(account.getName());
		name.setForeground(account.getColor());
		name.setHorizontalAlignment(SwingConstants.CENTER);
		add(name, BorderLayout.NORTH);

		chats = new ChatMessagesComponent();
		add(chats, BorderLayout.CENTER);

		JPanel pnl = new JPanel();
		ButtonGroup bgrp = new ButtonGroup();
		JRadioButton rbt1 = new JRadioButton(State.AVAILABLE.getLabel());
		rbt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				account.setState(State.AVAILABLE);
				room.sendMessage("State of user " + account.getName() +" is now " + account.getState().getLabel());
			}});
		bgrp.add(rbt1);
		pnl.add(rbt1);
		JRadioButton rbt2 = new JRadioButton(State.AWAY.getLabel());
		rbt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				account.setState(State.AWAY);
				room.sendMessage("State of user " + account.getName() +" is now " + account.getState().getLabel());
			}});
		bgrp.add(rbt2);
		pnl.add(rbt2);
		JRadioButton rbt3 = new JRadioButton(State.DND.getLabel());
		rbt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				account.setState(State.DND);
				room.sendMessage("State of user " + account.getName() +" is now " + account.getState().getLabel());
			}});
		bgrp.add(rbt3);
		pnl.add(rbt3);


		switch (account.getState()) {
		case AVAILABLE:
			rbt1.setSelected(true);
			break;
		case AWAY:
			rbt2.setSelected(true);
			break;
		case DND:
			rbt3.setSelected(true);
			break;
		}

		JPanel inputPnl = new JPanel();
		inputPnl.setLayout(new BorderLayout());
		inputField = new JTextField();

		sendButton = new JButton("Send");

		inputField.addActionListener(new AbstractAction()
		{
			private static final long serialVersionUID = 1L;

			@Override
			public void actionPerformed(ActionEvent e)
			{
				send();
			}
		});

		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				send();
			}
        });

		inputPnl.add(inputField, BorderLayout.CENTER);
		inputPnl.add(sendButton, BorderLayout.EAST);
		inputPnl.add(pnl, BorderLayout.NORTH);
		
		add(inputPnl, BorderLayout.SOUTH);

		setSize(400, 300);
		setVisible(true);
	}

	private void send(){
		if(inputField.getText().length() == 0)
			JOptionPane.showMessageDialog(null, "Dear " + account.getName() + ", please enter a message", "Warning!", JOptionPane.WARNING_MESSAGE);
		else
		{
			Message msg = new Message(inputField.getText(), account);
			room.sendMessage(msg);
			inputField.setText("");
		}
	}

	@Override
	public void receiveMessage(Message msg) {
		JLabel myLabel = new JLabel(msg.getSender().getName() + ": " + msg.getText());
		myLabel.setForeground(msg.getSender().getColor());
		messages.add(myLabel);
		seconds.add(30);
		chats.add(myLabel);
	}

	@Override
	public void receiveMessage(String text) {
		JLabel myLabel = new JLabel(text);
		myLabel.setForeground(java.awt.Color.GRAY);
		messages.add(myLabel);
		seconds.add(30);
		chats.add(myLabel);
	}

	@Override
	public Account getAccount() {
		return account;
	}

}
