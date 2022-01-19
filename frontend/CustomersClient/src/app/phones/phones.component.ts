import {Component, OnInit} from '@angular/core';
import {DataService} from "../data.service";
import {Phone} from "../model/Phone";

@Component({
  selector: 'app-phones',
  templateUrl: './phones.component.html',
  styleUrls: ['./phones.component.css']
})
export class PhonesComponent implements OnInit {

  phones: Array<Phone>;
  filteredPhones: Array<Phone>;

  selectedCountry: string = "all";
  selectedState: string = "all";

  getPhones(selectedCountry: string, selectedState: string){
    this.dataService.getPhones().subscribe(
      (next) => {
        this.phones = next;
        this.filteredPhones = this.filterPhones(selectedCountry, selectedState);
      }
    );

  }

  constructor(private dataService: DataService) {
  }

  ngOnInit(): void {

  }

  private filterByCountry(selectedCountry: string , phones: Array<Phone>) {
    if (selectedCountry == "all") return phones;
    return phones.filter(phone => phone.country.name.toLowerCase() == selectedCountry);
  }

  private filterByState(selectedState: string , phones: Array<Phone>) {
    if (selectedState == "all") return phones;
    return phones.filter(phone => phone.valid.toString() == selectedState);
  }

  private filterPhones(selectedCountry: string, selectedState: string) {
    this.filteredPhones = this.filterByCountry(selectedCountry, this.phones);
    this.filteredPhones = this.filterByState(selectedState, this.filteredPhones);
    return this.filteredPhones;
  }
}
