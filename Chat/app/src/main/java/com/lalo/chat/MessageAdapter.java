package com.lalo.chat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.lalo.chat.databinding.ChatListItemBinding;

public class MessageAdapter extends ListAdapter<Message, MessageAdapter.MessageViewHolder> {

    public static final DiffUtil.ItemCallback<Message> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Message>() {
                @Override
                public boolean areItemsTheSame(@NonNull Message oldItem, @NonNull Message newItem) {
                    return oldItem.equals(newItem);
                }

                @Override
                public boolean areContentsTheSame(@NonNull Message oldItem, @NonNull Message newItem) {
                    return oldItem.equals(newItem);
                }
            };

    protected MessageAdapter() {
        super(DIFF_CALLBACK);
    }

    @NonNull
    @Override
    public MessageAdapter.MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ChatListItemBinding binding = ChatListItemBinding.inflate(LayoutInflater.from(parent.getContext()));
        return new MessageViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageAdapter.MessageViewHolder holder, int position) {
        Message msg = getItem(position);
        holder.bind(msg);
    }


    class MessageViewHolder extends RecyclerView.ViewHolder{
        private final ChatListItemBinding binding;

        public MessageViewHolder(@NonNull ChatListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Message msg){
            binding.txtMessage.setText(msg.getMessage());
            if (msg.getId() == 1) {
                binding.botImage.setVisibility(View.VISIBLE);
            }
            binding.executePendingBindings();
        }


    }


}
