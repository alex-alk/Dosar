import { Chapter } from "../chapter/Chapter";

export interface Platform {
    id: number,
    chapters: Chapter[];
    name: string;
  }