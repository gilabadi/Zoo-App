﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Backend.Models
{
    public class Animal
    {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Story { get; set; }
        public int EncId { get; set; }
        public int Language { get; set; }
        public string Category { get; set; }
        public string Series { get; set; }
        public string Family { get; set; }
        public string Distribution { get; set; }
        public int Reproduction { get; set; }
        public string Food { get; set; }
        public int Preservation { get; set; }
    }
}