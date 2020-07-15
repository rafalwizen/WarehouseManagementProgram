import { Manufacturer } from './manufacturer';
export interface Item {
  id: number;
  name: string;
  weight: number;
  area: string;
  bookstand: number;
  shelf: number;
  availability: number;
  belongToCustomWarehouse: boolean;
  isDamaged: boolean;
  isTeritorialyRestricted: boolean;
  manufacturer: Manufacturer;
}
