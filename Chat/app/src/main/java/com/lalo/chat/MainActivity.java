package com.lalo.chat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.lalo.chat.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    ArrayList<Message> msgList;
    ArrayList<Message> responseList;

    MessageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.chatRecycler.setLayoutManager(new LinearLayoutManager(this));


        msgList = new ArrayList<>();

        responseList = new ArrayList<>();
        responseList.add(new Message("Sí", 1));
        responseList.add(new Message("No", 1));
        responseList.add(new Message("No lo creo", 1));
        responseList.add(new Message("Totalmente", 1));
        responseList.add(new Message("Falta mucho tiempo para eso", 1));
        responseList.add(new Message("Tú sabes la respuesta a esa pregunta", 1));
        responseList.add(new Message("¿Realmente lo crees?", 1));

        adapter = new MessageAdapter();
        binding.chatRecycler.setAdapter(adapter);
        adapter.submitList(msgList);

        binding.buttonSend.setOnClickListener(v -> {
            String newMsg = binding.editTextMessage.getText().toString();

            if(!newMsg.isEmpty()) {
                Random num = new Random();
                int randomMessage = num.nextInt(responseList.size());
                msgList.add(new Message(newMsg,0));
                msgList.add(responseList.get(randomMessage));
                adapter.notifyItemInserted(msgList.size()-1);
                binding.editTextMessage.getText().clear();
                binding.chatRecycler.smoothScrollToPosition(msgList.size() - 1);
            }
        });
    }
}