﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Backend.Models
{
    public class ContactInfo
    {
        public int Id { get; set; }
        public string Via { get; set; }
        public string Address { get; set; }
        public int Language { get; set; }
    }
}
