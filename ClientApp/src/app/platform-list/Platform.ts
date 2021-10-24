import { Chapter } from "../chapter-list/Chapter";

export interface Platform {
    id: number,
    chapters: Chapter[];
    name: string;
  }