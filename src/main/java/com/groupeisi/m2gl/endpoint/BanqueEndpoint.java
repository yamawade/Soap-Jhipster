package com.groupeisi.m2gl.endpoint;

import com.groupeisi.m2gl.AddClientRequest;
import com.groupeisi.m2gl.AddPaymentRequest;
import com.groupeisi.m2gl.AddTransferRequest;
import com.groupeisi.m2gl.ClientInfo;
import com.groupeisi.m2gl.ClientResponse;
import com.groupeisi.m2gl.GetSoldeRequest;
import com.groupeisi.m2gl.PaymentInfo;
import com.groupeisi.m2gl.PaymentResponse;
import com.groupeisi.m2gl.ServiceStatus;
import com.groupeisi.m2gl.SoldeResponse;
import com.groupeisi.m2gl.TransferInfo;
import com.groupeisi.m2gl.TransferResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BanqueEndpoint {

    private static final String NAMESPACE_URI = "http://www.groupeisi.com/banque";

    // ------------------- addClient -------------------
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addClientRequest")
    @ResponsePayload
    public ClientResponse addClient(@RequestPayload AddClientRequest request) {
        ClientResponse response = new ClientResponse();
        ClientInfo client = new ClientInfo();
        ClientInfo clientInfo = request.getClient();

        ServiceStatus status = new ServiceStatus();
        status.setStatus("SUCCESS");
        status.setMessage("Client ajouté avec succès");

        response.setStatus(status);
        response.setClient(clientInfo);

        return response;
    }

    // ------------------- getSolde -------------------
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSoldeRequest")
    @ResponsePayload
    public SoldeResponse getSolde(@RequestPayload GetSoldeRequest request) {
        SoldeResponse response = new SoldeResponse();
        response.setSolde(100000);
        return response;
    }

    // ------------------- addTransfer -------------------
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addTransferRequest")
    @ResponsePayload
    public TransferResponse addTransfer(@RequestPayload AddTransferRequest request) {
        TransferResponse response = new TransferResponse();
        TransferInfo transfer = request.getTransfer();

        ServiceStatus status = new ServiceStatus();
        status.setStatus("SUCCESS");
        status.setMessage("Transfert effectué avec succès");

        response.setTransfer(transfer);
        response.setStatus(status);

        return response;
    }

    // ------------------- addPayment -------------------
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addPaymentRequest")
    @ResponsePayload
    public PaymentResponse addPayment(@RequestPayload AddPaymentRequest request) {
        PaymentResponse response = new PaymentResponse();
        PaymentInfo payment = request.getPayment();

        ServiceStatus status = new ServiceStatus();
        status.setStatus("SUCCESS");
        status.setMessage("Paiement effectué avec succès");

        response.setPayment(payment);
        response.setStatus(status);

        return response;
    }
}
