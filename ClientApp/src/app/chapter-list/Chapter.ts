export interface Chapter {
    id: number,
    name: string;
    content: string;
    urlName: string;
    platform: {name: string, id: number}
  }