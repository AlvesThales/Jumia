import {Country} from "./Country";

export class Phone {

  number: string;
  valid: boolean;
  country: Country;


  constructor(number: string, valid: boolean, country: Country) {
    this.number = number;
    this.valid = valid;
    this.country = country;
  }
}
