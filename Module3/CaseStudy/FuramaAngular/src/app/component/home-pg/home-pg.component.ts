import {AfterContentChecked, Component, OnInit} from '@angular/core';
declare let paypal: any;
@Component({
  selector: 'app-home-pg',
  templateUrl: './home-pg.component.html',
  styleUrls: ['./home-pg.component.css']
})
export class HomePgComponent implements AfterContentChecked {

  addScript = false;
  finalAmount = 1;
  paypalLoad = true;
  paypalConfig = {
    env: 'sandbox',
    client: {
      sandbox: 'ATRpoRTol8I_JgSwufU61PavASUaN4e7SKpnlTCk7-Z-2Bc-iUZL8G3ifW0DEWD5eyTsT3e-zPA7pIeP',
      production: '<you-production-key here'
    },
    commit: true,
    payment: (data, actions) => {
      return actions.payment.create({
        payment: {
          transaction: [
            {amount: {total: this.finalAmount, currency: 'USD'}}
          ]
        }
      });
    },
    onAuthorize: (data, actions) => {
      return actions.payment.execute().then((payment) => {
      });
    }
  };
  ngAfterContentChecked(): void {
    if (!this.addScript){
      this.addPaypalScript().then(() => {
        paypal.Button.render(this.paypalConfig, '#paypal-checkout-btn');
        this.paypalLoad = false;
      });
    }
  }
  addPaypalScript(): any{
    this.addScript = true;
    return new Promise((resolve, reject) => {
      const scripttagElement = document.createElement('script');
      scripttagElement.src = 'https://www.paypalobjects.com/api/checkout.js';
      scripttagElement.onload = resolve;
      document.body.appendChild(scripttagElement);
    });
  }

}
