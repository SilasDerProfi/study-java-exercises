package de.dhbwka.java.exam.snatchat;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class SnatChatRoom {
	private String roomName;
	private List<SnatChatFrontend> snatChatWindows = new ArrayList<SnatChatFrontend>();

	public String getRoomName() {
		return roomName;
	}

	public SnatChatRoom(String roomName) {
		this.roomName = roomName;
	}

	public void register(SnatChatFrontend snatChatWindow) {

		try {
			List<String> lines = java.nio.file.Files.readAllLines(Paths.get("io/" + getRoomName() + ".txt"));
			
			if(lines.size() > 0)
			{
				lines.subList(lines.size() - 10 >= 0 ? lines.size() - 10 : 0, lines.size())
					.forEach(l -> snatChatWindow.receiveMessage(Message.rot13(l)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		snatChatWindows.add(snatChatWindow);
	}

	public void unregister(SnatChatFrontend s){
		snatChatWindows.remove(s);
	}

	public void sendMessage(Message msg){
		save(msg.getText());
		snatChatWindows.forEach(s -> s.receiveMessage(msg));
	}

	public void sendMessage(String text) {
		save(text);
		snatChatWindows.forEach(s -> s.receiveMessage(text));
	}

	private void save(String text) {
		try {
            try (FileWriter fw = new FileWriter("io/" + getRoomName() + ".txt", true)) {
                fw.append(Message.rot13(text) + "\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
