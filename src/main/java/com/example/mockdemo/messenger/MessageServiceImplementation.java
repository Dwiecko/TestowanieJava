package com.example.mockdemo.messenger;

public class MessageServiceImplementation implements MessageService {
    Validators valid = new Validators();

	public ConnectionStatus checkConnection(String server) {
        if (Validators.isValidURL(server)) return ConnectionStatus.SUCCESS;

        return ConnectionStatus.FAILURE;
	}

	public SendingStatus send(String server, String message) throws MalformedRecipientException {
        if (!Validators.isValidMessage(message)) throw new MalformedRecipientException();
        if (checkConnection(server) == ConnectionStatus.FAILURE) throw new MalformedRecipientException();

        if ((checkConnection(server) == ConnectionStatus.SUCCESS) && 
            (Validators.isValidMessage(message))) return SendingStatus.SENT;
        
        return SendingStatus.SENDING_ERROR;
    }
}
