import { Chapter } from './chapter';
export interface Platform {
  id: number;
  name: string;
  chapters: Chapter[];
}
