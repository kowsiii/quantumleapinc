package oop.quantumleapinc.vms.payload.form;

public class FormResponse {

    private FormConfigResponse formConfigResponse;

    private FormConfigInfoResponse formConfigInfoResponse;

    private FormDataResponse formDataResponse;

    public FormConfigResponse getFormConfigResponse() {
        return formConfigResponse;
    }

    public void setFormConfigResponse(FormConfigResponse formConfigResponse) {
        this.formConfigResponse = formConfigResponse;
    }

    public FormConfigInfoResponse getFormConfigInfoResponse() {
        return formConfigInfoResponse;
    }

    public void setFormConfigInfoResponse(FormConfigInfoResponse formConfigInfoResponse) {
        this.formConfigInfoResponse = formConfigInfoResponse;
    }

    public FormDataResponse getFormDataResponse() {
        return formDataResponse;
    }

    public void setFormDataResponse(FormDataResponse formDataResponse) {
        this.formDataResponse = formDataResponse;
    }
}
