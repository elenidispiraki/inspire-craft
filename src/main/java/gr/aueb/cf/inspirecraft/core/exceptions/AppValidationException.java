package gr.aueb.cf.inspirecraft.core.exceptions;

import org.springframework.validation.BindingResult;

public class AppValidationException extends Exception {
  private BindingResult bindingResult;

  public AppValidationException(BindingResult bindingResult) {
    super("Validation Failed");
    this.bindingResult = bindingResult;
  }

  public BindingResult getBindingResult() {
    return bindingResult;
  }
}
